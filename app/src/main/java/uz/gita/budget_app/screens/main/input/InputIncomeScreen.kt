package uz.gita.budget_app.screens.main.input

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.R
import uz.gita.budget_app.data.room.entity.CategoryEntity
import uz.gita.budget_app.screens.main.input.impl.InputIncomeViewModelImpl
import uz.gita.budget_app.ui.theme.BackgroundColor
import uz.gita.budget_app.ui.theme.PrimaryColorDark
import uz.gita.budget_app.ui.theme.SecondaryColor
import uz.gita.budget_app.utils.getDateFormat
import java.util.*

// Created by Jamshid Isoqov an 10/15/2022
class InputIncomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: InputIncomeViewModel = getViewModel<InputIncomeViewModelImpl>()
        val uiState = viewModel.collectAsState().value
        InputIncomeContent(uiState, viewModel::onEventDispatcher)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputIncomeContent(uiState: InputIncomeUiState, dispatcher: (InputIncomeIntent) -> Unit) {
    when (uiState) {
        is InputIncomeUiState.Success -> {
            var textPrice by remember { mutableStateOf("") }
            var textNote by remember { mutableStateOf("") }
            var category by remember { mutableStateOf(0L) }
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(1.dp, BackgroundColor, RoundedCornerShape(24.dp))
                        .background(
                            PrimaryColorDark, RoundedCornerShape(24.dp)
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_left),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 4.dp)
                            .size(42.dp)
                            .border(
                                1.dp,
                                SecondaryColor,
                                RoundedCornerShape(21.dp)
                            )
                            .clickable {
                                dispatcher.invoke(InputIncomeIntent.PrevClicked)
                            }
                            .padding(4.dp)
                    )
                    Text(
                        getDateFormat(Date(uiState.date)),
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_light),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(end = 4.dp)
                            .size(42.dp)
                            .border(
                                1.dp,
                                SecondaryColor,
                                RoundedCornerShape(21.dp)
                            )
                            .clickable {
                                dispatcher.invoke(InputIncomeIntent.NextClicked)
                            }
                            .padding(4.dp)
                    )
                }

                Text(
                    text = "Income",
                    modifier = Modifier.padding(16.dp, 8.dp),
                    color = SecondaryColor
                )

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_euro),
                        contentDescription = "",
                        modifier = Modifier
                            .size(36.dp)
                            .padding(8.dp)
                            .align(Alignment.CenterVertically)
                    )
                    OutlinedTextField(
                        value = textPrice,
                        onValueChange = {
                            textPrice = it
                        }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        label = {
                            Text(
                                text = "Amount",
                                modifier = Modifier.wrapContentHeight()
                            )
                        }
                    )
                }

                Text(
                    text = "Note",
                    modifier = Modifier.padding(16.dp, 8.dp),
                    color = SecondaryColor
                )

                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    OutlinedTextField(
                        value = textNote,
                        onValueChange = {
                            textNote = it
                        },
                        modifier = Modifier
                            .weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        label = {
                            Text(
                                text = "Note"
                            )
                        },
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_camera),
                                contentDescription = ""
                            )
                        }
                    )
                }

                Text(
                    text = "Category",
                    modifier = Modifier.padding(16.dp, 8.dp),
                    color = SecondaryColor
                )
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .weight(1f)
                ) {

                    CategoryItems(categoryItems = uiState.categoriesList.map {
                        CategoryEntity(it.id.toLong(), it.name, it.image)
                    }, {
                        category = it.id
                    }, {
                        dispatcher.invoke(InputIncomeIntent.NavigateToAddCategory)
                    }, category)
                }
                CustomButtonView(
                    text = "Submit",
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                ) {
                    dispatcher.invoke(
                        InputIncomeIntent.SubmitButtonClick(
                            textPrice.toDouble(),
                            uiState.date,
                            textNote,
                            2
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun InputIncomePreview() {
    // InputIncomeContent(uiState, viewModel::onEventDispatcher)
}