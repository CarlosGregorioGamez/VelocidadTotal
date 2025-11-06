package com.example.appf1.components

import android.icu.text.CaseMap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TitleComponent(title: String, textColor: Color = MaterialTheme.colorScheme.primary, textStyle: TextStyle= MaterialTheme.typography.titleLarge) {

    Box(
        modifier = Modifier
            .width(width = 300.dp)
            .height(height = 30.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = textColor,
            style = textStyle,
            fontFamily = FontFamily.Default,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun TitleComponentPreview() {
    TitleComponent(
        title = "Ejemplo de Titulo",
        textStyle = MaterialTheme.typography.titleLarge
    )
}