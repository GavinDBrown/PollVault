package com.gavindev.pollvault

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.gavindev.pollvault.dagger.base.InjectingFragmentActivity
import com.gavindev.pollvault.dagger.component.ActivityComponent
import com.gavindev.pollvault.databinding.ActivityPollBinding
import com.gavindev.pollvault.networking.PollApi
import javax.inject.Inject

/**
 * Created by gbrown on 9/10/16.
 */

class PollActivity : InjectingFragmentActivity() {

    @Inject
    lateinit var pollApi: PollApi

    lateinit var viewBinding: ActivityPollBinding

    override fun injectComponent(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_poll)
    }
}