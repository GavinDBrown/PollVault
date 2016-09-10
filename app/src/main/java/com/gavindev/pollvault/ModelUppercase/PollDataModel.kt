package com.gavindev.pollvault.ModelUppercase

/**
 * Created by gbrown on 9/10/16.
 */

data class Poll(val question: String, val pollResponses: Collection<PollResponse>)

data class PollResponse(val option: String, var value: Float)

data class CreateResult(val pollId: Int, val authToken: String)

data class ViewResult(val votable: Boolean, val poll: Poll, val votingPeriod: VotingPeriod, val results: Collection<PollResponse>)

data class VotingPeriod(val start: Long, val end: Long)