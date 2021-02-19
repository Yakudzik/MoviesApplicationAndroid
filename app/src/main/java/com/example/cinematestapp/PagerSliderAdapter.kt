package com.example.cinematestapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cinematestapp.fragments.*

class PagerSliderAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FragmentDrama1()
            1 -> FragmentDocks2()
            2 -> FragmentTheatralical3()
            3 -> FragmentFuture4()
            4 -> FragmentAnimation5()
            else -> getItem(position)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Drama"
            1 -> "Docs"
            2 -> "Theater"
            3 -> "Features"
            else -> "Animation"
        }
    }

    override fun getCount(): Int {
        return 5
    }
}