package com.gavindev.pollvault.dagger.module

import android.content.Context
import android.support.v7.app.AppCompatActivity

import com.gavindev.pollvault.dagger.PerActivity

import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    internal fun provideActivity(): AppCompatActivity {
        return activity
    }

    @Provides
    @PerActivity
    internal fun provideActivityContext(): Context {
        return activity
    }

}
