package com.gavindev.pollvault.createpoll

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.gavindev.pollvault.R
import com.gavindev.pollvault.databinding.CreatePollOptionsBinding

/**
 * Created by gbrown on 9/10/16.
 */

class CreatePollOptionsFragment: CreatePollFragment() {

    lateinit var viewBinding: CreatePollOptionsBinding

    @BindView(R.id.options_recycler_view)
    lateinit var optionsView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.create_poll_options, container, false)
        val rootView = viewBinding.root
        ButterKnife.bind(this, rootView)

        optionsView.layoutManager = LinearLayoutManager(context)
        optionsView.adapter = PollOptionsAdapter(poll)

        return rootView
    }

    @OnClick(R.id.add_poll_option)
    fun addPollOption(view: View) {
        poll.pollOptions.add("")
        optionsView.adapter.notifyDataSetChanged()
    }
}