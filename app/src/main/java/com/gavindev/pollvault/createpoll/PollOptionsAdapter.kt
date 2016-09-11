package com.gavindev.pollvault.createpoll

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gavindev.pollvault.R
import com.gavindev.pollvault.databinding.PollOptionBinding
import com.gavindev.pollvault.model.Poll

/**
 * Created by gbrown on 9/10/16.
 */


class PollOptionsAdapter(val poll: Poll): RecyclerView.Adapter<PollOptionsAdapter.PollOptionBindingHolder>() {
    override fun getItemCount(): Int {
        return poll.pollOptions.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PollOptionBindingHolder {
        return PollOptionBindingHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.poll_option, parent, false))
    }

    override fun onBindViewHolder(holder: PollOptionBindingHolder?, position: Int) {
        @Suppress("MISSING_DEPENDENCY_CLASS") // https://youtrack.jetbrains.com/issue/KT-12402
        holder?.pollOptionBinding?.poll = poll
        holder?.pollOptionBinding?.index = position
    }

    class PollOptionBindingHolder(val pollOptionBinding: PollOptionBinding) : RecyclerView.ViewHolder(pollOptionBinding.root) {}

}