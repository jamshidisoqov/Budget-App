package uz.gita.budget_app.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Jamshid Isoqov an 10/13/2022
@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val image: String
)
