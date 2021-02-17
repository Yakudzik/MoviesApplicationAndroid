package com.example.cinematestapp

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematestapp.moviesData.MoviesData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.one_movie_item.view.*


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//    private val title: TextView = itemView.findViewById(R.id.movie_title_cardID_oneItem)
//    private val cover: ImageView = itemView.findViewById(R.id.movie_coverID_oneItem)
//
//    fun bind(movie: MoviesData) {
//        title.text = movie.content.component5().content.get(position).title
//        Picasso.get()
//            .load(movie.content.component5().content.get(position).cover?.createImageURL)
//            .into(cover)
//    }
}