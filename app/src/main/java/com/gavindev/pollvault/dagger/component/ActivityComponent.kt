package com.gavindev.pollvault.dagger.component

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.gavindev.pollvault.createpoll.LaunchActivity
import com.gavindev.pollvault.viewpoll.PollActivity
import com.gavindev.pollvault.dagger.PerActivity
import com.gavindev.pollvault.dagger.base.InjectorComponentGetter
import com.gavindev.pollvault.dagger.module.ActivityModule
import dagger.Component


@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
abstract class ActivityComponent {

    companion object {

        fun createActivityComponent(activity: AppCompatActivity): ActivityComponent {
            return DaggerActivityComponent.builder()
                    .appComponent(AppComponent.getAppComponent(activity))
                    .activityModule(ActivityModule(activity))
                    .build()
        }

        @SuppressWarnings("unchecked")
        fun getParentActivityComponent(context: Context): ActivityComponent {
            return (context as InjectorComponentGetter<ActivityComponent>).component
        }

    }

    abstract fun inject(activity: LaunchActivity)
    abstract fun inject(activity: PollActivity)
}
