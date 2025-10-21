package com.example.appf1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appf1.R


@Composable
fun CustomImage(){

    Box(modifier = Modifier.height(height = 100.dp).width(width = 50.dp)){
        Image(painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen de prueba")
    }
}

@Preview
@Composable
fun CustomImagePreview(){
    CustomImage()
}