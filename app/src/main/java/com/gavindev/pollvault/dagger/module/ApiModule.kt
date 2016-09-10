package com.gavindev.pollvault.dagger.module

import com.gavindev.pollvault.dagger.PerApp
import com.gavindev.pollvault.networking.ApiService

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @PerApp
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}
