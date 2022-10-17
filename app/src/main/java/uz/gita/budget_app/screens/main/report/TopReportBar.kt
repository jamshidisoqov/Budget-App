package uz.gita.budget_app.screens.main.report

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.gita.budget_app.R
import uz.gita.budget_app.screens.main.report.intent_uistate.R_Intent


@Composable
fun ReportBar(
    eventDispatcher: (R_Intent) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {

        Text(text = "Month Report", modifier = Modifier.align(Alignment.Center))

        Column(modifier = Modifier.align(Alignment.CenterEnd)) {
            IconButton(
                onClick = { expanded = !expanded },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_expand_more_24),
                    contentDescription = "Expand Button"
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {

                DropdownMenuItem(
                    onClick = {
                              eventDispatcher(R_Intent.MonthlyReport)
                    },
                    text =
                    {
                        Text(text = "Monthly Report")
                    },

                    )
                DropdownMenuItem(
                    onClick = {
                              eventDispatcher(R_Intent.CategoryReport)
                    }, text =
                    {
                        Text(text = "Category Report")
                    }
                )

            }
        }

    }


}