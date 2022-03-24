package com.panjidwisatrio.mangaboytwo.data.dummy

import com.panjidwisatrio.mangaboytwo.R
import com.panjidwisatrio.mangaboytwo.data.Manga

object MangaData {
    private val mangaTitle = arrayOf(
        "Itsu Demo Jitaku ni Kaereru Ore wa, Isekai de Gyoushoujin o Hajimemashita Bahasa Indonesia",
        "Leveling With The Gods Bahasa Indonesia",
        "Aishiteru Game wo Owarasetai Bahasa Indonesia",
        "Moukin-chan Bahasa Indonesia",
    )
    private val mangaImage = intArrayOf(
        R.drawable.contoh_1,
        R.drawable.contoh_2,
        R.drawable.contoh_3,
        R.drawable.contoh_4,
    )

    val listData : ArrayList<Manga>
        get() {
            val list = arrayListOf<Manga>()
            for (position in mangaTitle.indices) {
                val manga = Manga()
                manga.title = mangaTitle[position]
                manga.img = mangaImage[position]
                list.add(manga)
            }
            return list
        }
}