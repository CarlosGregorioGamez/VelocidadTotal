package com.example.appf1.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R


@Composable
fun CustomImage(painter: Painter = painterResource(R.drawable.ic_launcher_foreground),
                descripcion: String = "Imagen de prueba") {

    Box(modifier = Modifier
        .height(height = 100.dp)
        .width(width = 50.dp)) {
        Image(
            painter = painter,
            contentDescription = descripcion,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun CustomImagePreview() {
    CustomImage()
}