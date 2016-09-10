package com.gavindev.pollvault.createpoll

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.gavindev.pollvault.R
import com.gavindev.pollvault.dagger.base.InjectingFragmentActivity
import com.gavindev.pollvault.dagger.component.ActivityComponent
import com.gavindev.pollvault.databinding.ActivityLaunchBinding
import com.gavindev.pollvault.networking.PollApi
import com.gavindev.pollvault.viewpoll.PollActivity
import javax.inject.Inject

class LaunchActivity : InjectingFragmentActivity() {

    @Inject
    lateinit var pollApi: PollApi

    lateinit var viewBinding: ActivityLaunchBinding


    override fun injectComponent(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_launch)

    }

    fun pollCreated(view: View) {
        startActivity(Intent(this, PollActivity::class.java))
    }
}
