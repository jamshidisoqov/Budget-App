package uz.gita.budget_app.data.models

import uz.gita.budget_app.data.room.entity.ImagesEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeEntity
import java.io.Serializable

// Created by Jamshid Isoqov an 10/14/2022
data class IncomeData(
    val incomeEntity: IncomeEntity,
    val category: IncomeCategoryEntity,
    val images: List<ImagesEntity> = emptyList()
): Serializable
