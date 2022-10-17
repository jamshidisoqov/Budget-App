package uz.gita.budget_app.screens.main.report.category_report.intent_uistate

import uz.gita.budget_app.R
import uz.gita.budget_app.data.models.CategoryModel
import java.io.Serializable

sealed interface C_R_Intent{
    class OpenCategoryDetails(categoryModel: CategoryModel): C_R_Intent
    object Back: C_R_Intent
    class MonthAndWeekSelect(index: Int): C_R_Intent
}


data class C_R_UiState(
    val expenseItems: List<CategoryModel> = emptyList(),
    val incomeItems: List<CategoryModel> = emptyList(),
    val categoryModel: CategoryModel = CategoryModel("loading", R.raw.store),
    val transactionReportByCategoryList: List<Serializable> = emptyList(),
)