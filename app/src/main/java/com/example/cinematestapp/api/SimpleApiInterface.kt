package com.example.cinematestapp.api


import com.example.cinematestapp.moviesData.MoviesData
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SimpleApiInterface {

    @GET("./api/main_page")
    fun searchMovie(): Call<MoviesData>

    companion object {

        operator fun invoke(): SimpleApiInterface { // настраиваем retrofit и  okHttp

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://signalmediacorp.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SimpleApiInterface::class.java)
        }
    }
}
