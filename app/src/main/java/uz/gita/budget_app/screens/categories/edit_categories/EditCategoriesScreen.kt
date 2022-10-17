package uz.gita.budget_app.screens.categories.edit_categories

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.budget_app.data.models.CategoryModel
import uz.gita.budget_app.screens.categories.edit_categories.impl.EditCategoryViewModelImpl
import uz.gita.budget_app.ui.theme.PrimaryColor
import uz.gita.budget_app.utils.AllCategoriesList
import uz.gita.budget_app.utils.CategoryItems

// Created by Jamshid Isoqov an 10/14/2022
class EditCategoriesScreen(private val type: Int) : AndroidScreen() {
    @Composable
    override fun Content() {

        val viewModel: EditCategoryViewModel = getViewModel<EditCategoryViewModelImpl>()
        EditCategoryScreenContent(eventDispatcher = viewModel::onEventDispatcher, type = type)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("InvalidColorHexValue")
@Composable
fun EditCategoryScreenContent(
    eventDispatcher: (EditCategoryIntent) -> Unit, type: Int
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        var iconName by remember {
            mutableStateOf(CategoryModel("Baby", 1))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(40.dp)
                .padding(10.dp),
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Back",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    color = Color.LightGray

                )

                Text(
                    text = "Edit Category",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = PrimaryColor
                )
                Text(
                    text = "Add",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp, color = Color.Blue,
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            eventDispatcher.invoke(EditCategoryIntent.AddClick(type, iconName))
                        }
                )

            }
            Text(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                    .padding(vertical = 10.dp, horizontal = 6.dp),
                text = iconName.name,
                color = Color.LightGray,
                textAlign = TextAlign.Justify,
                style = TextStyle(
                    textAlign = TextAlign.Left,
                    color = PrimaryColor,
                    fontSize = 16.sp
                )
            )

            Text(
                "Icon",
                Modifier.padding(top = 8.dp, bottom = 8.dp),
                fontSize = 16.sp,
                color = Color.LightGray
            )

            CategoryItems(categoryItems = AllCategoriesList.list) {
                iconName = it
            }
        }
    }
}


@Preview
@Composable
fun EditScreenPreview() {
    EditCategoryScreenContent(eventDispatcher = {}, 1)
}
