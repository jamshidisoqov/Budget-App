package uz.gita.budget_app.screens.main.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.R
import uz.gita.budget_app.R
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen

// Created by Jamshid Isoqov an 10/14/2022
class SettingsScreen : AndroidScreen() {
    @Composable
    override fun Content() {

    }
}


@Preview
@Composable
fun SettingsScreens(){
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Black),


        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ToolbarSettings()

        }
        SettingsItem()
    }
}
@Composable
fun  SettingsItem() {

    Column() {


        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.White)

        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                ActionButton(
                    icon = R.drawable.ic_baseline_category_24,
                    onClick = { },
                    modifier = Modifier.padding(4.dp),

                    )

                Column(Modifier.padding(0.dp, top = 5.dp)) {
                    TitleText(modifier = Modifier, text = "Category")

                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(end = 8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        icon = R.drawable.ic_baseline_arrow_forward_24,
                        onClick = { },
                        modifier = Modifier.padding(4.dp),

                        )


                }
            }
        }
        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.White)


        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                ActionButton(
                    icon = R.drawable.ic_baseline_currency_bitcoin_24,
                    onClick = { },
                    modifier = Modifier.padding(4.dp),

                    )

                Column(Modifier.padding(0.dp, top = 5.dp)) {
                    TitleText(modifier = Modifier, text = "Currency")

                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(end = 8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        icon = R.drawable.ic_baseline_arrow_forward_24,
                        onClick = { },
                        modifier = Modifier.padding(4.dp),

                        )


                }
            }
        }
        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.White)


        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                ActionButton(
                    icon = R.drawable.ic_baseline_password_24,
                    onClick = { },
                    modifier = Modifier.padding(4.dp),

                    )

                Column(Modifier.padding(0.dp, top = 5.dp)) {
                    TitleText(modifier = Modifier, text = "Pin Password")

                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(end = 8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        icon = R.drawable.ic_baseline_arrow_forward_24,
                        onClick = { },
                        modifier = Modifier.padding(4.dp),

                        )


                }
            }
        }
        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.White)


        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                ActionButton(
                    icon = R.drawable.ic_baseline_access_time_24,
                    onClick = { },
                    modifier = Modifier.padding(4.dp),

                    )

                Column(Modifier.padding(0.dp, top = 5.dp)) {
                    TitleText(modifier = Modifier, text = "Reminder")

                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(end = 8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ActionButton(
                        icon = R.drawable.ic_baseline_arrow_forward_24,
                        onClick = { },
                        modifier = Modifier.padding(4.dp),

                        )


                }
            }
        }
        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.White)


        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                ActionButton(
                    icon = R.drawable.ic_baseline_dark_mode_24,
                    onClick = { },
                    modifier = Modifier.padding(4.dp),

                    )

                Column(Modifier.padding(0.dp, top = 5.dp)) {
                    TitleText(modifier = Modifier, text = "Dark Mode")
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(end = 8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    val checkedState = remember { mutableStateOf(true) }
                    Switch(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it }
                    )


                }
            }
        }
        Box(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(Color.White)


        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

                ) {
                ActionButton(
                    icon = R.drawable.ic_delete,
                    onClick = { },
                    modifier = Modifier.padding(4.dp),

                    )

                Column(Modifier.padding(0.dp, top = 5.dp)) {
                    TitleText(modifier = Modifier, text = "Delete All Data")
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier.padding(end = 8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {



                }
            }
        }
    }
}
@Composable
fun TitleText(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier.padding(start =50.dp),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        color = Color.Gray
    )
}

@Composable
fun TitleContentText(text: String, modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.Black,

        )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarSettings(){
    Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {


        TopAppBar(


            title = { Text(text = "Settings", modifier = Modifier.padding(start = 140.dp)) },


            Modifier.background(color = Color.Green))
    } }

@Composable
fun ActionButton(
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
