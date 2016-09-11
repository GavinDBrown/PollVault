package com.gavindev.pollvault.createpoll.sharepoll

/**
 * Created by gbrown on 9/11/16.
 */
interface PollSharingEmailsProvider {
    fun getPollSharingEmails(): MutableList<String>
}