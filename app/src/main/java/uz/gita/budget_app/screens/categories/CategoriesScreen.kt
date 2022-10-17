package uz.gita.budget_app.screens.categories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.budget_app.data.models.CategoryModel
import uz.gita.budget_app.screens.main.settings.TitleContentText
import uz.gita.budget_app.ui.theme.BudgetAppTheme

// Created by Jamshid Isoqov an 10/14/2022
class CategoriesScreen:AndroidScreen() {
    @Composable
    override fun Content() {

    }
}

@Preview
@Composable
fun CategoryScreen() {
//    val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),


        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ToolbarCategory()
        }
        ExpanceText()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarCategory() {
    TopAppBar(
        title = { Text(text = "Category", color = Color.Red, modifier = Modifier.padding(start = 100.dp)) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, "Menu")
            }
        })
}

@Composable
fun ExpanceText(){
    Text(text = "Expense", modifier = Modifier.padding(10.dp))
//    ExpanceTextItem()
}

//@Composable
//fun ExpanceTextItem(){
//    Column() {
//        val data = listOf(
//            CategoryItem(group = CategoryFulldata(1, R.drawable.ic_edit,"Azimjon")),CategoryItem(group = CategoryFulldata(1, R.drawable.ic_edit,"Azimjon")),CategoryItem(group = CategoryFulldata(1, R.drawable.ic_edit,"Azimjon")),CategoryItem(group = CategoryFulldata(1, R.drawable.ic_edit,"Azimjon")))
//
//        LazyVerticalGrid(
//            cells = GridCells.Fixed(3),
//            contentPadding = PaddingValues(8.dp)
//        ) {
//            items(data) { item ->
//                Card(
//                    modifier = Modifier
//                        .padding(4.dp)
//                        .background(color = Color.Black),
//
//                    ) {
//                    Text(
//                        text = item,
//                        fontSize = 24.sp,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.padding(24.dp)
//                    )
//                }
//            }
//        }
//    }
//}
@Composable
fun LazyVerticalGrid(
    cells: GridCells,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: LazyGridScope.() -> Unit
) { }

@Composable
fun CategoryItem(
    group: CategoryModel,

    ) {
    Box(modifier = Modifier
        .padding(5.dp)
        .background(color = Color.White)
        .clickable { }){
        Column(
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            ActionButton1(
                icon = group.imageId ,
                onClick = {},
                modifier = Modifier.padding(4.dp),

                )
//            Text(text = "Bank", modifier = Modifier.padding(start = 12.dp))
            TitleContentText(modifier = Modifier.padding(start = 12.dp), text = group.name)
        }
    }

}
@Composable
fun ActionButton1(
    icon: Int,
    modifier: Modifier,

    onClick: () -> Unit,
    shape: Shape = RectangleShape
) {
    IconButton(
        onClick = onClick, modifier = modifier
            .clip(shape)
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "icon bor")
    }
}
@Preview
@Composable
fun CAtegoryItem(){
    BudgetAppTheme() {
        CategoryItem(group = CategoryModel("Bank",uz.gita.budget_app.R.drawable.ic_edit))
    }
}


