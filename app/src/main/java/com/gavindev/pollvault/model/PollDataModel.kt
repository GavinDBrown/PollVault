package com.gavindev.pollvault.model

/**
 * Created by gbrown on 9/10/16.
 */

data class Poll(var question: String, var pollResponses: Collection<PollResponse>, val period: VotingPeriod)

data class PollResponse(var option: String, var value: Float)

data class CreateResult(val pollId: Int, val authToken: String)

data class ViewResult(val votable: Boolean, val poll: Poll, val votingPeriod: VotingPeriod, val results: Collection<PollResponse>)

data class VotingPeriod(var start: Long, var end: Long)