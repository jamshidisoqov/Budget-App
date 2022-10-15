package uz.gita.budget_app.utils

import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Bundle
import android.util.Log.d
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.R
import uz.gita.budget_app.data.models.CategoryModel
import uz.gita.budget_app.data.prefs.MySharedPref
import uz.gita.budget_app.ui.theme.BackgroundColor
import uz.gita.budget_app.ui.theme.Gray
import javax.inject.Inject


@Composable
fun CategoryItemView(
    categoryModel: CategoryModel
) {
    Column(
        modifier = Modifier
            .padding(2.dp)
            .width(92.dp)
            .height(92.dp)
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = categoryModel.imageId),
                contentDescription = "category_image",
                modifier = Modifier
                    .height(32.dp)
                    .width(32.dp)
            )
            Text(text = categoryModel.name, fontFamily = Fonts.poppinsFamily, fontWeight = FontWeight.Normal)
        }

    }
}

@Preview
@Composable
fun CategoryItemPreview() {

    BudgetAppTheme {
        Surface {

            val gridItems = listOf(
                CategoryModel("Food", R.raw.food),
                CategoryModel("Gas", R.raw.gas),
                CategoryModel("Fun", R.raw.`fun`),
            )
            CategoryItems(categoryItems = AllCategoriesList.list)

        }

    }
}


@Composable
fun RowItem(number: Int) {
    // Simple Row Composable
    Row(
        modifier = Modifier
            .size(100.dp) // Size 100 dp
            .background(Color.White) // Background White
            .border(width = 1.dp, color = Color.Unspecified), // Border color green

        // Align Items in Center
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Text Composable which displays some
        // kind of message , text color is green
        Text(text = "This Is Item Number $number", color = Color.Unspecified)
    }
}

@Composable
fun ColumnItem(number: Int) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(Color.White)
            .border(1.dp, Color.Unspecified),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "This Is Item Number $number", color = Color.Unspecified)
    }
}
