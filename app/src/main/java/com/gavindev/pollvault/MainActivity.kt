package com.gavindev.pollvault

import android.os.Bundle
import com.gavindev.pollvault.dagger.base.InjectingFragmentActivity
import com.gavindev.pollvault.dagger.component.ActivityComponent

class MainActivity : InjectingFragmentActivity() {

    override fun injectComponent(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }
}
