package com.gavindev.pollvault.createpoll

import android.content.Context
import android.support.v4.app.Fragment
import com.gavindev.pollvault.model.Poll

/**
 * Created by gbrown on 9/11/16.
 */
open class CreatePollFragment: Fragment() {

    internal lateinit var poll: Poll

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context as PollProvider
        poll = context.getPoll()
    }
}