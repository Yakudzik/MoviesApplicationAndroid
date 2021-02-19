package com.example.cinematestapp.api


import com.example.cinematestapp.moviesData.Content
import com.example.cinematestapp.moviesData.ContentX
import com.example.cinematestapp.moviesData.Movies
import com.example.cinematestapp.moviesData.MoviesData
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SimpleApiInterface {

    @GET("./api/main_page")
    fun searchMovie(): Call<MoviesData>

    companion object {

          operator fun invoke(): SimpleApiInterface {

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()


            val retrofit = Retrofit.Builder()
                .baseUrl("https://signalmediacorp.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return  retrofit.create(SimpleApiInterface::class.java)

        }
    }
}