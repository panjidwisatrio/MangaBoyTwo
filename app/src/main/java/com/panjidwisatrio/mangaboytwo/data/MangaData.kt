package com.panjidwisatrio.mangaboytwo.data

import com.panjidwisatrio.mangaboytwo.R
import com.panjidwisatrio.mangaboytwo.model.MangaPopular
import com.panjidwisatrio.mangaboytwo.model.MangaSlider
import com.panjidwisatrio.mangaboytwo.model.MangaTerbaru

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

    val listDataSlider : ArrayList<MangaSlider>
        get() {
            val list = arrayListOf<MangaSlider>()
            for (position in mangaTitle.indices) {
                val manga = MangaSlider()
                manga.title = mangaTitle[position]
                manga.img = mangaImage[position]
                list.add(manga)
            }
            return list
        }

    val listDataHorizontal : ArrayList<MangaPopular>
        get() {
            val list = arrayListOf<MangaPopular>()
            for (position in mangaTitle.indices) {
                val manga = MangaPopular()
                manga.title = mangaTitle[position]
                manga.img = mangaImage[position]
                list.add(manga)
            }
            return list
        }

    val listDataGrid : ArrayList<MangaTerbaru>
        get() {
            val list = arrayListOf<MangaTerbaru>()
            for (position in mangaTitle.indices) {
                val manga = MangaTerbaru()
                manga.title = mangaTitle[position]
                manga.img = mangaImage[position]
                list.add(manga)
            }
            return list
        }
}