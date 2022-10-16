package uz.gita.budget_app.screens.main.input

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.budget_app.R
import uz.gita.budget_app.ui.theme.BackgroundColor
import uz.gita.budget_app.ui.theme.PrimaryColorDark
import uz.gita.budget_app.ui.theme.SecondaryColor
import uz.gita.budget_app.utils.AllCategoriesList

// Created by Jamshid Isoqov an 10/15/2022
class InputIncomeScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        InputIncomeContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputIncomeContent() {
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
                    .padding(4.dp)
            )
            Text(
                text = "Feb 24,2022",
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
                    .padding(4.dp)
            )
        }

        Text(text = "Income", modifier = Modifier.padding(16.dp, 8.dp), color = SecondaryColor)

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
                    .size(48.dp)
                    .border(
                        1.dp,
                        SecondaryColor,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(8.dp)
            )
            OutlinedTextField(
                value = "0.00",
                onValueChange = {

                },
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text(
                        text = "0.00",
                        modifier = Modifier.wrapContentHeight()
                    )
                }
            )
        }

        Text(text = "Note", modifier = Modifier.padding(16.dp, 8.dp), color = SecondaryColor)

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            OutlinedTextField(
                value = "0.00",
                onValueChange = {

                },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                placeholder = {
                    Text(
                        text = "0.00",
                        modifier = Modifier.wrapContentHeight()
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

            uz.gita.budget_app.utils.CategoryItems(categoryItems = AllCategoriesList.list) {

            }
        }
        CustomButtonView(
            text = "Submit",
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
        ) {
            //TODO click handle
        }
    }
}

@Preview
@Composable
fun InputIncomePreview() {
    InputIncomeContent()
}