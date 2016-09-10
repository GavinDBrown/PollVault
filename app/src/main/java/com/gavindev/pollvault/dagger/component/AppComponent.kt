package com.gavindev.pollvault.dagger.component


import android.content.Context
import com.gavindev.pollvault.dagger.PerApp
import com.gavindev.pollvault.dagger.module.ApiModule
import com.gavindev.pollvault.dagger.module.AppModule
import com.gavindev.pollvault.dagger.module.GsonModule
import com.gavindev.pollvault.dagger.module.RetrofitModule
import com.gavindev.pollvault.networking.PollApi

import dagger.Component


@PerApp
@Component(modules = arrayOf(AppModule::class, ApiModule::class, RetrofitModule::class, GsonModule::class))
abstract class AppComponent {

    companion object {

        private var appComponent: AppComponent? = null

        fun getAppComponent(context: Context): AppComponent {
            appComponent = appComponent ?: DaggerAppComponent.builder().appModule(AppModule(context.applicationContext)).build()
            return appComponent!!
        }
    }

    abstract fun apiService(): PollApi

}
