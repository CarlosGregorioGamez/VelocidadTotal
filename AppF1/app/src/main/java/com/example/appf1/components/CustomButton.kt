package com.example.appf1.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(buttonText: String, action: () -> Unit) {

    Box(
        modifier = Modifier
            .width(width = 150.dp)
            .height(height = 50.dp)
    ) {

        Button(
            onClick = action,
            modifier = Modifier.fillMaxSize(),
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.DarkGray
            ),
        ) {
            Text(
                text = buttonText
            )
        }
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    CustomButton(
        buttonText = "Texto de prueba"
    ) {
        Log.e("Prueba", "Boton de prueba")
    }
}