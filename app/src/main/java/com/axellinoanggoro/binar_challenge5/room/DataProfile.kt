package com.axellinoanggoro.binar_challenge5.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class DataProfile(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo
    var username : String,
) : Parcelable
