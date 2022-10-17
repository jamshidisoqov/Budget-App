package uz.gita.budget_app.screens.categories.add_category

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.data.room.entity.CategoryEntity
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.screens.categories.LazyVerticalGrid
import uz.gita.budget_app.screens.categories.add_category.impl.AddCategoryViewModelImpl
import uz.gita.budget_app.screens.main.input.CategoryItems
import uz.gita.budget_app.ui.theme.PrimaryColor


// Created by Jamshid Isoqov an 10/14/2022
class AddCategoriesScreen : AndroidScreen() {
    @Composable
    override fun Content() {

        val viewModel: AddCategoryViewModel = getViewModel<AddCategoryViewModelImpl>()
        AddCategoryScreen(
            uiState = viewModel.collectAsState().value,
            eventDispatcher = viewModel::onEventDispatcher
        )
    }
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun AddCategoryScreen(
    uiState: AddCategoryUiState,
    eventDispatcher: (AddCategoryIntent) -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {


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
                    "Back",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    modifier = Modifier.clickable {
                        eventDispatcher.invoke(AddCategoryIntent.Back)
                    }
                )

                Text(
                    "Edit Category",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = PrimaryColor
                )
                Text(
                    "Remove",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp, color = Color.Red
                )
            }
            if (uiState is AddCategoryUiState.Success) {
                AddCategoryItems(
                    incomeList = uiState.incomeList,
                    expansesList = uiState.expanseList,
                    incomeLastClick = {
                        eventDispatcher.invoke(AddCategoryIntent.EditCategory(1))
                    }) {
                    eventDispatcher.invoke(AddCategoryIntent.EditCategory(2))
                }
            }

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    AddCategoryScreen(uiState = AddCategoryUiState.Success(), eventDispatcher = {})
}

@Composable
fun AddCategoryItems(
    incomeList: List<IncomeCategoryEntity>,
    expansesList: List<ExpansesCategoryEntity>,
    incomeLastClick: () -> Unit,
    expansesLastClick: () -> Unit
) {

    var incomeLastSelected by remember {
        mutableStateOf(0L)
    }

    var expansesLastSelected by remember {
        mutableStateOf(0L)
    }


    LazyVerticalGrid(
        cells = GridCells.Fixed(4)
    ) {

        item(span = { GridItemSpan(4) }) {
            Text(
                "Income",
                Modifier.padding(top = 8.dp, bottom = 8.dp),
                fontSize = 14.sp,
                color = Color.LightGray
            )
        }
        items(incomeList.size + 1) {
            CategoryItems(categoryItems = incomeList.map {
                CategoryEntity(
                    it.id.toLong(),
                    it.name,
                    it.image
                )
            }, onClick = {
                incomeLastSelected = it.id
            }, endClick = {
                incomeLastClick.invoke()
            }, lastSelection = incomeLastSelected)
        }
        item(span = { GridItemSpan(4) })
        {
            Text(
                "Expanses",
                Modifier.padding(top = 8.dp, bottom = 8.dp),
                fontSize = 14.sp,
                color = Color.LightGray
            )
        }


        items(expansesList.size + 1) {
            CategoryItems(categoryItems = expansesList.map {
                CategoryEntity(
                    it.id.toLong(),
                    it.name,
                    it.image
                )
            }, onClick = {
                expansesLastSelected = it.id
            }, endClick = {
                expansesLastClick.invoke()
            }, lastSelection = expansesLastSelected)
        }
    }

}

