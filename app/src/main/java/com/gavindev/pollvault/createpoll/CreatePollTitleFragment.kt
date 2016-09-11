package com.gavindev.pollvault.createpoll

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gavindev.pollvault.R
import com.gavindev.pollvault.databinding.CreatePollTitleBinding

/**
 * Created by gbrown on 9/10/16.
 */

class CreatePollTitleFragment: CreatePollFragment() {

    lateinit var viewBinding: CreatePollTitleBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.create_poll_title, container, false)
        @Suppress("MISSING_DEPENDENCY_CLASS") // https://youtrack.jetbrains.com/issue/KT-12402
        viewBinding.poll = poll
        return viewBinding.root
    }
}