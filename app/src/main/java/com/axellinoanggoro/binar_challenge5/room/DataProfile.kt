package com.axellinoanggoro.binar_challenge5.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class DataProfile(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var username : String,
    var nama : String,
    var dob : String,
    var alamat : String
) : Parcelable
