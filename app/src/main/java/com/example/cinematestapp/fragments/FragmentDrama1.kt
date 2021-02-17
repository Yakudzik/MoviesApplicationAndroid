package com.example.cinematestapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinematestapp.PhotoAdapter
import com.example.cinematestapp.R
import com.example.cinematestapp.api.SimpleApi
import com.example.cinematestapp.moviesData.MoviesData
import kotlinx.android.synthetic.main.t_e_s_t_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentDrama1 : Fragment() {

    companion object {
        fun newInstance() = FragmentDrama1()
    }

    private lateinit var viewModelDrama_1: FragmentDrama1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment__drama_1_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelDrama_1 = ViewModelProvider(this).get(FragmentDrama1ViewModel::class.java)
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
                        recycle_view_for_moview.adapter = PhotoAdapter(listOf(response.body()!!), 0)
                    }
                }
            }

            override fun onFailure(call: Call<MoviesData?>, t: Throwable) {
                Log.e("Error", "Buba Error")
            }
        })
    }

}