package uz.gita.budget_app.screens.pin

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import uz.gita.budget_app.R
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen

// Created by Jamshid Isoqov an 10/14/2022
class PinScreen:AndroidScreen() {
    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}
@Preview
@Composable
fun PasswordScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(color = Color.White),


        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ToolbarPassword()

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            ImeActionOutlinedTextField()
            ImeActionOutlinedTextField()
            ImeActionOutlinedTextField()
            ImeActionOutlinedTextField()
        }
        Column(
            Modifier.padding(
                2.dp,
            )
        ) {
            TitleText1111(
                modifier = Modifier.padding(start = 6.dp),
                text = "Please enter you PIN password to continute"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        DefoultButton()
    }
}


@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Preview
@Composable
fun ImeActionOutlinedTextField() {

    val state = remember { mutableStateOf(TextFieldValue(text = "")) }

    OutlinedTextField(
        value = state.value,
        onValueChange = { value ->
            if (value.text.length < 2) {
                state.value = value
            }
        },
        label = { Text(stringResource(id = R.string.app_nameee)) },
        modifier = Modifier
            .padding(5.dp)
            .size(60.dp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.NumberPassword
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarPassword() {
    TopAppBar(
        title = {
            Text(
                text = "PIN password",
                color = Color.Black,
                modifier = Modifier.padding(start = 80.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, "Menu")
            }
        })
}

@Composable
fun TitleText1111(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier.padding(),
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        color = Color.Gray
    )
}

@Preview
@Composable
fun DefoultButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .testTag("Next"),

        ) {
        DefoultText()
    }
}

@Composable
fun DefoultText() {
    Text(text = stringResource(id = R.string.next))
}