package com.example.thegioitruyen.ducdataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParagraphDataClass(var idParagraph: Int,var imgContent: Int?,var textContent:String?,
    var position:Int,var idChapter: Int,var isComic: Boolean=true) : Parcelable
