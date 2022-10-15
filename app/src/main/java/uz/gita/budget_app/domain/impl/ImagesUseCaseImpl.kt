package uz.gita.budget_app.domain.impl

import uz.gita.budget_app.data.room.entity.ImagesEntity
import uz.gita.budget_app.domain.ImagesUseCase
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

class ImagesUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : ImagesUseCase {
    override suspend fun insertImagesEntity(imagesEntity: ImagesEntity) {
        repository.insertImagesEntity(imagesEntity)
    }

    override suspend fun updateImagesEntity(imagesEntity: ImagesEntity) {
        repository.updateImagesEntity(imagesEntity)
    }

    override suspend fun deleteImagesEntity(imagesEntity: ImagesEntity) {
        repository.deleteImagesEntity(imagesEntity)
    }

    override suspend fun getAllExpansesImages(expansesId: Int): List<ImagesEntity> =
        repository.getAllExpansesImages(expansesId)

    override suspend fun getAllIncomeImages(incomeId: Int): List<ImagesEntity> =
        repository.getAllIncomeImages(incomeId)
}