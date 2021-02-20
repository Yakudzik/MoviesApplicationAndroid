package com.example.cinematestapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.one_movie_item.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpSliderTab()
    }

    private fun setUpSliderTab() { //слайдер по жанрам
        val myAdapter = PagerSliderAdapter(supportFragmentManager)
        viewpager.adapter = myAdapter
        sliding_tabs.setupWithViewPager(viewpager)

    }

}