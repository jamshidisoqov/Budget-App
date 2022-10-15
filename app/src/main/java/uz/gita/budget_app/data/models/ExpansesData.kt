package uz.gita.budget_app.data.models

import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.ExpansesEntity
import uz.gita.budget_app.data.room.entity.ImagesEntity

// Created by Jamshid Isoqov an 10/14/2022
data class ExpansesData(
    val expansesEntity: ExpansesEntity,
    val category: ExpansesCategoryEntity,
    val imagesList: List<ImagesEntity> = emptyList()
)
