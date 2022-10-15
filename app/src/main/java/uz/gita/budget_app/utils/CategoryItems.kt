package uz.gita.budget_app.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.budget_app.data.models.CategoryModel
import uz.gita.budget_app.ui.theme.BudgetAppTheme

@Composable
fun CategoryItems(
    categoryItems: List<CategoryModel>,
    onClick: () -> Unit
){
    val cols = 4
    LazyVerticalGrid(horizontalArrangement = Arrangement.Center, columns = GridCells.Fixed(cols)) {

        items(categoryItems) {
            CategoryItemView(it, onClick)
        }
    }
}

@Preview
@Composable
fun CategoryItemPreview() {

    BudgetAppTheme {
        Surface {
            CategoryItems(categoryItems = AllCategoriesList.list, {})
        }

    }
}
