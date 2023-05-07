package com.axellinoanggoro.binar_challenge5.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPopularMovie(
    var image : String,
    var title : String,
    var date : String,
    var desc : String
): Parcelable
