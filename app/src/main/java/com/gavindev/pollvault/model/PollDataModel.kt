package com.gavindev.pollvault.model

import java.util.*

/**
 * Created by gbrown on 9/10/16.
 */

data class Poll(var question: String = "", var pollOptions: MutableList<String> = ArrayList<String>(), val period: VotingPeriod? = null)

data class PollResponse(var option: String, var value: Float)

data class CreateResult(val pollId: Int, val authToken: String)

data class ViewResult(val votable: Boolean, val poll: Poll, val votingPeriod: VotingPeriod, val results: List<PollResponse>)

data class VotingPeriod(var start: Long, var end: Long)