package uz.gita.budget_app.data.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

// Created by Jamshid Isoqov an 10/13/2022
@Entity(
    tableName = "incomes",
    foreignKeys = [
        ForeignKey(
            entity = IncomeCategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["incomeCategoryId"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class IncomeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val currency_id: Int,
    val incomeCategoryId: Int,
    val currencyValue: Double,
    val dollarValue: Double,
    val comment: String,
    val date: Long
)
