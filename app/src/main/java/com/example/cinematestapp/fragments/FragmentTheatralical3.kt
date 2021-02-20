package com.example.cinematestapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinematestapp.PhotoAdapter
import com.example.cinematestapp.R
import com.example.cinematestapp.api.SimpleApiInterface
import com.example.cinematestapp.moviesData.MoviesData
import kotlinx.android.synthetic.main.t_e_s_t_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentTheatralical3 : Fragment() {

    companion object {
        fun newInstance() = FragmentTheatralical3()
    }

    private lateinit var viewModel3: FragmentTheatralical3ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_theatralical3_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel3 = ViewModelProvider(this).get(FragmentTheatralical3ViewModel::class.java)
        getData()
    }

    private fun getData() {
        SimpleApiInterface.invoke().searchMovie().enqueue(object : Callback<MoviesData?> {
            override fun onResponse(call: Call<MoviesData?>, response: Response<MoviesData?>) {
                recycle_view_for_moview.apply {
//                    Log.d("Get response","Response get! ")
                    recycle_view_for_moview.layoutManager = LinearLayoutManager(activity)

                    recycle_view_for_moview.adapter = PhotoAdapter(
                        listOf(response.body()!!),
                        2
                    )
                }
            }

            override fun onFailure(call: Call<MoviesData?>, t: Throwable) {
//                Log.e("Error retrofit","Error Error Error ")
            }
        })
    }
}