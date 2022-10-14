package uz.gita.budget_app.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Jamshid Isoqov an 10/13/2022
@Entity(tableName = "calendar_data")
data class CalendarEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String,
    val type: Int
)
