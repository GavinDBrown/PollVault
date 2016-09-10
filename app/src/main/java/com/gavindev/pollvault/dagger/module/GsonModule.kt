package com.gavindev.pollvault.dagger.module

import com.gavindev.pollvault.dagger.PerApp
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory


@Module
class GsonModule {

    @Provides
    @PerApp
    internal fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @PerApp
    internal fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
                GsonBuilder().create())
    }

}
