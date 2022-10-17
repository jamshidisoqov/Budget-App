package uz.gita.budget_app.directions.impl

import uz.gita.budget_app.data.models.CategoryModel
import uz.gita.budget_app.directions.CategoryReportDirection
import uz.gita.budget_app.navigation.AppNavigation
import uz.gita.budget_app.screens.main.report.category_report.details_screen.CategoryDetails
import javax.inject.Inject

class CategoryReportDirectionImpl@Inject constructor(
    private val appNavigation: AppNavigation
) : CategoryReportDirection {
    override suspend fun navigateToCategoryReportDetails(categoryModel: CategoryModel) {
        appNavigation.navigateTo(CategoryDetails())
    }

    override suspend fun back() {
        appNavigation.back()
    }
}