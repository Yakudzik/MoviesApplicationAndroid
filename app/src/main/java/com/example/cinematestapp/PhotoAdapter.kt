package com.example.cinematestapp


import android.view.ViewGroup
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematestapp.moviesData.MoviesData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.one_movie_item.view.*

class PhotoAdapter(private val dataList: List<MoviesData>, val frameNumber:Int) :
    RecyclerView.Adapter<ViewHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, something: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.one_movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int {

        return dataList[0].content[frameNumber].content.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[0].content[frameNumber].content[position]

        holder.itemView.movie_title_cardID_oneItem.text =
            data.title

        Picasso.get()
            .load(data.cover?.createImageURL)
            .into(holder.itemView.movie_coverID_oneItem)
        // return holder.bind(dataList[position])
    }
}

