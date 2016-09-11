package com.gavindev.pollvault.createpoll.sharepoll

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gavindev.pollvault.R
import com.gavindev.pollvault.databinding.PollEmailBinding

/**
 * Created by gbrown on 9/11/16.
 */
class PollShareAdapter(val shareEmails: MutableList<String>): RecyclerView.Adapter<PollShareAdapter.PollEmailBindingHolder>() {
    override fun getItemCount(): Int {
        return shareEmails.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PollEmailBindingHolder {
        return PollEmailBindingHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.poll_email, parent, false))
    }

    override fun onBindViewHolder(holder: PollEmailBindingHolder?, position: Int) {
        @Suppress("MISSING_DEPENDENCY_CLASS") // https://youtrack.jetbrains.com/issue/KT-12402
        holder?.pollEmailBinding?.emailList = shareEmails
        holder?.pollEmailBinding?.index = position
    }

    class PollEmailBindingHolder(val pollEmailBinding: PollEmailBinding) : RecyclerView.ViewHolder(pollEmailBinding.root) {}

}