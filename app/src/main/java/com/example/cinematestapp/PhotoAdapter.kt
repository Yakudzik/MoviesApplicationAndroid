package com.example.cinematestapp


import android.app.LauncherActivity
import android.app.ProgressDialog.show
import android.view.ViewGroup
import android.content.Context
import android.content.Intent
import android.icu.util.LocaleData
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematestapp.moviesData.ContentX
import com.example.cinematestapp.moviesData.MoviesData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.one_movie_item.*
import kotlinx.android.synthetic.main.one_movie_item.view.*
import kotlinx.android.synthetic.main.one_page_full_screen.*
import kotlinx.android.synthetic.main.one_page_full_screen.view.*
import kotlinx.android.synthetic.main.t_e_s_t_fragment.view.*
import java.time.format.DateTimeFormatter

class PhotoAdapter(
    private val dataList: List<MoviesData>,
    private val frameNumber: Int,
    //private val lister: ViewHolder
) :
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

        holder.title.text = data.title

        Picasso.get()
            .load(data.cover?.createImageURL)
            .into(holder.cover)

        holder.itemView.movie_coverID_oneItem.setOnClickListener {

            var intent = Intent(context, OneFullScreen::class.java)
            intent.putExtra("FilmCover", dataList[0].content[frameNumber].content[position].cover?.createImageURL)
            intent.putExtra("FilmName", dataList[0].content[frameNumber].content[position].title)
            intent.putExtra("FilmDate", dataList[0].content[frameNumber].content[position].createdAt)
            intent.putExtra("FilmGenre", dataList[0].content[frameNumber].content[position].genre.title)

            val langSize:Int = dataList[0].content[frameNumber].content[position].languages.size
            var langStr =""
            for (i in 0 until langSize)
                langStr += "${dataList[0].content[frameNumber].content[position].languages[i].title}, "

            intent.putExtra("FilmLanguage",langStr)
            context.startActivity(intent)
        }

        Log.d("Hello from click", "Hello from position ${position}")
    }
}



