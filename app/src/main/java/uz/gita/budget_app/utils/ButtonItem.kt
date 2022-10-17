package uz.gita.budget_app.utils

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.budget_app.ui.theme.Blue

@Composable
fun ButtonView(
    text: String,
    onClick: () -> (Unit)
) {
    Button(
        onClick = onClick,
        Modifier.width(282.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue)
    ) {
        Text(text = text)

    }
}

@Preview
@Composable
fun BtnPrev() {
    ButtonView("Madina", {})
}