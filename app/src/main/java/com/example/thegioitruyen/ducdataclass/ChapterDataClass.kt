package com.example.thegioitruyen.ducdataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import java.io.Serializable
@Parcelize
data class ChapterDataClass(var idChapter: Int, var title: String,
                            var dateCreated: String): Parcelable
