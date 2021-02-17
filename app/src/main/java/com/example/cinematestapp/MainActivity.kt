package com.example.cinematestapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinematestapp.api.SimpleApi
import com.example.cinematestapp.moviesData.MoviesData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.t_e_s_t_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpSliderTab()

    }

    private fun setUpSliderTab() {
        val myAdapter = PagerSliderAdapter(supportFragmentManager)
        viewpager.adapter = myAdapter
        sliding_tabs.setupWithViewPager(viewpager)

    }

}