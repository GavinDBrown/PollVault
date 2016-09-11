package com.gavindev.pollvault.createpoll

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gavindev.pollvault.R
import com.gavindev.pollvault.databinding.CreatePollOptionsBinding

/**
 * Created by gbrown on 9/10/16.
 */

class CreatePollOptionsFragment: Fragment() {

    lateinit var viewBinding: CreatePollOptionsBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.create_poll_options, container, false)

        return viewBinding.root
    }
}