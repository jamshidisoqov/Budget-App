package uz.gita.budget_app.data.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

// Created by Jamshid Isoqov an 10/14/2022
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: T):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<T>)

    @Update
    suspend fun update(data: T):Long

    @Update
    suspend fun update(data: List<T>)

    @Delete
    suspend fun delete(data: T)

    @Delete
    suspend fun delete(data: List<T>)

}