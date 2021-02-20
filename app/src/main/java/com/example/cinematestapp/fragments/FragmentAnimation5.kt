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

class FragmentAnimation5 : Fragment() {

    companion object {
        fun newInstance() = FragmentAnimation5()
    }

    private lateinit var viewModel5: FragmentAnimation5ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animation5_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel5 = ViewModelProvider(this).get(FragmentAnimation5ViewModel::class.java)
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
                        4
                    )
                }
            }

            override fun onFailure(call: Call<MoviesData?>, t: Throwable) {
//                Log.e("Error retrofit","Error Error Error ")
            }
        })
    }

}