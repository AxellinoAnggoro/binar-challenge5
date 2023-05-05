package com.axellinoanggoro.binar_challenge5.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ProfileDAO {
    @Query("SELECT * from DataProfile where username = (:username)")
    fun getUsername(username : String) : List<DataProfile>
}