package uz.gita.budget_app.screens.categories.edit_categories

import uz.gita.budget_app.data.models.CategoryModel
import uz.gita.budget_app.utils.AppViewModel

// Created by Jamshid Isoqov an 10/17/2022
interface EditCategoryViewModel : AppViewModel<EditCategoryIntent, Unit, Nothing>


sealed interface EditCategoryIntent {
    data class AddClick(
        val type:Int,
        val categoryModel: CategoryModel
    ):EditCategoryIntent
}