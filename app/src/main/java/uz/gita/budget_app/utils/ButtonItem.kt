package uz.gita.budget_app.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.gita.budget_app.ui.theme.BudgetAppTheme

@Composable
fun ButtonView(
    text: String,
    onClick: () -> (Unit)
) {
    BudgetAppTheme() {
        Column() {
            Button(onClick = onClick, Modifier.width(282.dp)) {
                Text(text = text)
            }
        }
    }
}