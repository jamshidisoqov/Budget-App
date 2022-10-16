package uz.gita.budget_app.screens.main.input

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.budget_app.data.room.entity.CategoryEntity
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.utils.AllCategoriesList
import uz.gita.budget_app.utils.Fonts

@Composable
fun CategoryItems(
    categoryItems: List<CategoryEntity>,
    onClick: () -> Unit
) {
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
            CategoryItems(categoryItems = listOf(
                CategoryEntity(1, "Home", 1),
                CategoryEntity(1, "Input", 2),
                CategoryEntity(1, "Home", 3),
                CategoryEntity(1, "Home", 4),
            )
            ) {}
        }

    }
}


@Composable
fun CategoryItemView(
    category: CategoryEntity,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(2.dp)
            .width(92.dp)
            .height(92.dp)
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .clickable {
                onClick.invoke()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(AllCategoriesList.list[category.image].imageId),
                contentDescription = "category_image",
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
            Text(
                text = category.name,
                fontFamily = Fonts.poppinsFamily,
                fontWeight = FontWeight.Normal
            )
        }

    }
}

