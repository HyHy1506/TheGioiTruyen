package com.example.thegioitruyen.ducdataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class GenreDataClass(var idGenre: Int, var title: String): Parcelable
