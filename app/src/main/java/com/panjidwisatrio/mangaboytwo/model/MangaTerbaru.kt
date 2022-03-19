package com.panjidwisatrio.mangaboytwo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaTerbaru(
    var title: String = "",
    var img : Int = 0
) : Parcelable
