package com.gavindev.pollvault.createpoll

import com.gavindev.pollvault.model.Poll

/**
 * Created by gbrown on 9/11/16.
 */
interface PollProvider {
    fun getPoll(): Poll
}