package com.example.cinematestapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cinematestapp.fragments.*

class PagerSliderAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0-> TEST()
            1 -> FragmentDrama1()
            //2 -> FragmentTwo2Docs()
//            2 -> FragmentThree3Theatralical()
//            3 -> FragmentFour4FeatureFilms()
//            4 -> FragmentFive5Animation()
            else -> getItem(position)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0-> "TestFragment"
            1 -> "Drama"
        //    2 -> "Docs"
//            2 -> "Theater"
//            3 -> "Features"
            else -> "Animation"
        }
    }

    override fun getCount(): Int {
        return 2
    }
}