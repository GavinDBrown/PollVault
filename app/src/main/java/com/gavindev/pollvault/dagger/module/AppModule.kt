package com.gavindev.pollvault.dagger.module

import android.content.Context
import android.content.SharedPreferences

import com.gavindev.pollvault.dagger.PerApp

import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    @PerApp
    internal fun provideApplicationContext(): Context {
        return context
    }

    @Provides
    @PerApp
    internal fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("com.gavindev.app_preferences", Context.MODE_PRIVATE)
    }

}
