package uz.gita.budget_app.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// Created by Jamshid Isoqov an 10/13/2022
@Entity(tableName = "expanses")
data class ExpansesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val currency_id: Int,
    val expansesCategoryId: Int,
    val currencyValue: Double,
    val dollarValue: Double,
    val comment: String,
    val date:Long
)
