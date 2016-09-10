package com.gavindev.pollvault.dagger.module

import com.gavindev.pollvault.BuildConfig
import com.gavindev.pollvault.dagger.PerApp
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    @PerApp
    internal fun provideRetrofit(okHttpClient: OkHttpClient,
                                 gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder().baseUrl("api.github.com").client(okHttpClient).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
    }

    @Provides
    @PerApp
    internal fun provideDefaultOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BASIC
        else
            HttpLoggingInterceptor.Level.NONE)
    }
}
