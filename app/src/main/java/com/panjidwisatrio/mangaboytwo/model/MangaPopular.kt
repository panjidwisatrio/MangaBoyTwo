package com.panjidwisatrio.mangaboytwo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaPopular(
    var title: String = "",
    var img : Int = 0
) : Parcelable
