package com.example.cinematestapp



import android.view.ViewGroup
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.cinematestapp.moviesData.MoviesData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.one_movie_item.view.*


class PhotoAdapter(
    private val dataList: List<MoviesData>,
    private val frameNumber: Int,
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

        return dataList[0].content[frameNumber].content.size // достаем размер категории
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //заполняем карточку

        val data = dataList[0].content[frameNumber].content[position]

        holder.title.text = data.title

        Picasso.get()
            .load(data.cover?.createImageURL)
            .into(holder.cover)

        holder.itemView.movie_coverID_oneItem.setOnClickListener { //клик по карточке

            var intent = Intent(context, OneFullScreen::class.java)
            intent.putExtra("FilmCover", dataList[0].content[frameNumber].content[position].cover?.createImageURL) //передаем данные для полного экрана
            intent.putExtra("FilmName", dataList[0].content[frameNumber].content[position].title)
            intent.putExtra("FilmDate", dataList[0].content[frameNumber].content[position].createdAt)
            intent.putExtra("FilmGenre", dataList[0].content[frameNumber].content[position].genre.title)

            val langSize:Int = dataList[0].content[frameNumber].content[position].languages.size //формирую строку языков
            var langStr =""
            for (i in 0 until langSize)
                langStr += "${dataList[0].content[frameNumber].content[position].languages[i].title}, "

            intent.putExtra("FilmLanguage",langStr)
            context.startActivity(intent)
        }

       // Log.d("Hello from click", "Hello from position ${position}") //клик по карточке
    }
}



