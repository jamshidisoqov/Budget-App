package uz.gita.budget_app.data.models

import uz.gita.budget_app.data.room.entity.ImagesEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity

// Created by Jamshid Isoqov an 10/14/2022
data class IncomeData(
    val id: Int,
    val incomeCategoryId: Int,
    val currencyValue: Double,
    val dollarValue: Double,
    val comment: String,
    val category: IncomeCategoryEntity,
    val images: List<ImagesEntity> = emptyList()
)
