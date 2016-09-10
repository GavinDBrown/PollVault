package com.gavindev.pollvault.dagger.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gavindev.pollvault.dagger.component.ActivityComponent

abstract class InjectingFragmentActivity : AppCompatActivity(), InjectorComponentGetter<ActivityComponent> {

    protected lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        // Create component first so it's available to child fragments
        activityComponent = ActivityComponent.createActivityComponent(this);
        super.onCreate(savedInstanceState)
        injectComponent(activityComponent)
    }

    override fun getComponent(): ActivityComponent {
        return activityComponent
    }

    protected abstract fun injectComponent(component: ActivityComponent)

}
