package com.gavindev.pollvault.createpoll

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.gavindev.pollvault.createpoll.polloptions.CreatePollOptionsFragment
import com.gavindev.pollvault.createpoll.sharepoll.CreatePollShareFragment

/**
 * Created by gbrown on 9/10/16.
 */

class CreatePollPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            1 -> {
                return CreatePollOptionsFragment()
            }
            2 -> {
                return CreatePollShareFragment()
            }
        }
        // default to initial fragment
        return CreatePollTitleFragment()
    }

    override fun getCount(): Int {
        return 3
    }
}