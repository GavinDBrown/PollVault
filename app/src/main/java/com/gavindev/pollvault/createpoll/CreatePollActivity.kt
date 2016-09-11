package com.gavindev.pollvault.createpoll

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import com.gavindev.pollvault.R
import com.gavindev.pollvault.createpoll.sharepoll.PollSharingEmailsProvider
import com.gavindev.pollvault.dagger.base.InjectingFragmentActivity
import com.gavindev.pollvault.dagger.component.ActivityComponent
import com.gavindev.pollvault.databinding.ActivityCreatePollBinding
import com.gavindev.pollvault.model.Poll
import com.gavindev.pollvault.networking.PollApi
import com.gavindev.pollvault.viewpoll.PollActivity
import me.relex.circleindicator.CircleIndicator
import javax.inject.Inject

class CreatePollActivity : PollProvider, PollSharingEmailsProvider, InjectingFragmentActivity(){

    @Inject
    lateinit var pollApi: PollApi

    @BindView(R.id.create_poll_pager)
    lateinit var createPollViewPager: ViewPager
    @BindView(R.id.view_pager_circle_indicator)
    lateinit var circleIndicator: CircleIndicator

    private lateinit var viewBinding: ActivityCreatePollBinding
    private lateinit var createPollPagerAdapter: CreatePollPagerAdapter

    private val poll = Poll()
    private val pollSharingEmails: MutableList<String> = arrayListOf("", "")

    override fun injectComponent(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_create_poll)
        @Suppress("MISSING_DEPENDENCY_CLASS") // https://youtrack.jetbrains.com/issue/KT-12402
        viewBinding.poll = poll
        ButterKnife.bind(this)
        createPollPagerAdapter = CreatePollPagerAdapter(supportFragmentManager)
        createPollViewPager.adapter = createPollPagerAdapter
        circleIndicator.setViewPager(createPollViewPager)
    }

    override fun getPoll(): Poll {
        return poll
    }

    override fun getPollSharingEmails(): MutableList<String> {
        return pollSharingEmails
    }

    fun pollCreated(view: View) {
        startActivity(Intent(this, PollActivity::class.java))
    }

    override fun onBackPressed() {
        if (createPollViewPager.currentItem === 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            createPollViewPager.currentItem = createPollViewPager.currentItem - 1
        }
    }
}
