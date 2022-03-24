package com.panjidwisatrio.mangaboytwo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga(
    var title: String = "",
    var img : Int = 0
) : Parcelable
