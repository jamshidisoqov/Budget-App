package uz.gita.budget_app.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import uz.gita.budget_app.data.models.CategoryModel

@Composable
fun CategoryItems(
    categoryItems: List<CategoryModel>
){
    val cols = 4
    LazyVerticalGrid(horizontalArrangement = Arrangement.Center, columns = GridCells.Fixed(cols)) {

        item(span = { GridItemSpan(cols) })
        {
            Text("Expense")
        }


        items(categoryItems) {
            CategoryItemView(it)
        }
        item(span = { GridItemSpan(cols) })
        {
            Text("Income")
        }


        items(categoryItems) {
            CategoryItemView(it)
        }
    }
}