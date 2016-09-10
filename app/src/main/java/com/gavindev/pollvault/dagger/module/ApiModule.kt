package com.gavindev.pollvault.dagger.module

import com.gavindev.pollvault.dagger.PerApp
import com.gavindev.pollvault.networking.PollApi

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @PerApp
    internal fun providePollApi(retrofit: Retrofit): PollApi {
        return retrofit.create(PollApi::class.java)
    }

}
