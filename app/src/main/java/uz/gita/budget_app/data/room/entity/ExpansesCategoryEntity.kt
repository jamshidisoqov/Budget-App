package uz.gita.budget_app.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Jamshid Isoqov an 10/13/2022
@Entity(tableName = "expanses_category")
data class ExpansesCategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: Int
)
