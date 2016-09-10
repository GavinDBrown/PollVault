package com.gavindev.pollvault.networking

import com.gavindev.pollvault.model.CreateResult
import com.gavindev.pollvault.model.Poll
import com.gavindev.pollvault.model.PollResponse
import com.gavindev.pollvault.model.ViewResult
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import rx.Observable

interface PollApi {

    @POST("/create")
    fun createPoll(poll: Poll): Observable<CreateResult>

    @POST("/create/share")
    fun sharePoll(authToken: String, emails: List<String>): Observable<Response>

    @GET("/poll/{id}")
    fun viewPoll(@Path("id") pollId: String, authToken: String): Observable<ViewResult>

    @POST("/poll/vote/{id}")
    fun vote(@Path("id") pollId: String, authToken: String, vote: Collection<PollResponse>): Observable<ViewResult>

}