package com.example.cinematestapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinematestapp.PhotoAdapter
import com.example.cinematestapp.R
import com.example.cinematestapp.api.SimpleApi
 import com.example.cinematestapp.moviesData.MoviesData

import kotlinx.android.synthetic.main.t_e_s_t_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TEST : Fragment() {

    companion object {
        fun newInstance() = TEST()
    }

    private lateinit var viewModel: TESTViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.t_e_s_t_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TESTViewModel::class.java)
        getData()
    }

    private fun getData() {
        SimpleApi().searchMovie().enqueue(object : Callback<MoviesData?> {
            override fun onResponse(
                call: Call<MoviesData?>,
                response: Response<MoviesData?>
            ) {
                if (response.isSuccessful) {
                    recycle_view_for_moview.apply {
                        recycle_view_for_moview.layoutManager = LinearLayoutManager(activity)

                        recycle_view_for_moview.adapter = PhotoAdapter(listOf(response.body()!!), 4)
                    }
                }
            }

            override fun onFailure(call: Call<MoviesData?>, t: Throwable) {
//                Toast.makeText(activity, "Buba Error", Toast.LENGTH_SHORT).show()
                Log.e("Error", "Buba Error")
            }
        })
    }
}