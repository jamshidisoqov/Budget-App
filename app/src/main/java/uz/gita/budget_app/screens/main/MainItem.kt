package uz.gita.budget_app.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.budget_app.R
import uz.gita.budget_app.ui.theme.BackgroundColorDark
import uz.gita.budget_app.ui.theme.Red

// Created by Jamshid Isoqov an 10/6/2022


@Composable
fun BottomNavItem(
    modifier: Modifier,
    imageRes: Int,
    name: String,
    isSelected: Boolean,
    block: () -> Unit
) {

    Column(
        modifier.clickable {
            block.invoke()
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(
                if (isSelected) Red
                else BackgroundColorDark
            )
        )
        if (isSelected) {
            Text(text = name, color = Red)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainItemPreview() {
    BottomNavItem(
        modifier = Modifier.fillMaxSize(),
        imageRes = R.drawable.ic_input,
        name = "Input",
        isSelected = true
    ) {

    }
}