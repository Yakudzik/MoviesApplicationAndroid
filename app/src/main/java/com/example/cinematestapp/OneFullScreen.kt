package com.example.cinematestapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.one_full_screen.*

class OneFullScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.one_full_screen)

        val cinemaData = intent
        val cinemaCover = cinemaData.getStringExtra("FilmCover") // принимаем данные из адаптера по по ключу
        val cinemaName = cinemaData.getStringExtra("FilmName")
        val cinemaDate = cinemaData.getStringExtra("FilmDate")
        val cinemaGenre = cinemaData.getStringExtra("FilmGenre")
        val cinemaLanguage = cinemaData.getStringExtra("FilmGenre")

        Picasso.get() //выводим полученные данные
            .load(cinemaCover)
            .into(poster)

        nazvanie.text = cinemaName

        val dataVipuska: List<String> = cinemaData.toString().split(" ")
        val godVipuska: List<String> = dataVipuska[0].split("-")
        data_sozdania.text =
            "Дата выпуска:${godVipuska[2] + "." + godVipuska[1] + "." + godVipuska[0]}"

        janre.text = "Жанр: $cinemaGenre"

        yaziki.text.lastIndexOf("Доступные языки: $cinemaLanguage", 2)

    }
}