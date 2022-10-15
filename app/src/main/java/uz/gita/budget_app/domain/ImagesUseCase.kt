package uz.gita.budget_app.domain

import uz.gita.budget_app.data.room.entity.ImagesEntity

// Created by Jamshid Isoqov an 10/14/2022
interface ImagesUseCase {

    suspend fun insertImagesEntity(imagesEntity: ImagesEntity)

    suspend fun updateImagesEntity(imagesEntity: ImagesEntity)

    suspend fun deleteImagesEntity(imagesEntity: ImagesEntity)

    suspend fun getAllExpansesImages(expansesId: Int): List<ImagesEntity>

    suspend fun getAllIncomeImages(incomeId: Int): List<ImagesEntity>

}