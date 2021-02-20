package com.example.cinematestapp


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematestapp.moviesData.Content
import com.example.cinematestapp.moviesData.MoviesData
import kotlinx.android.synthetic.main.one_movie_item.view.*
import java.text.FieldPosition


class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.movie_title_cardID_oneItem //берем id для холдера в которые будем записывать данные
    val cover: ImageView = itemView.movie_coverID_oneItem
 }
