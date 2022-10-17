package uz.gita.budget_app.directions

import uz.gita.budget_app.data.models.CategoryModel

interface CategoryReportDirection {
    suspend fun navigateToCategoryReportDetails(categoryModel: CategoryModel)
    suspend fun back()
}
