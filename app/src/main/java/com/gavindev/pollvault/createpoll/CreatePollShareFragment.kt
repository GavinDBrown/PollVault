package com.gavindev.pollvault.createpoll

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gavindev.pollvault.R
import com.gavindev.pollvault.databinding.CreatePollShareBinding

/**
 * Created by gbrown on 9/10/16.
 */

class CreatePollShareFragment: Fragment() {

    lateinit var viewBinding: CreatePollShareBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.create_poll_share, container, false)

        return viewBinding.root
    }
}