package com.example.appf1.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.appf1.R

@Composable
fun TopBarExample(title: String) {
    Row {
        Text(text = title)
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Ejemplo"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(topBarTitle: String) {

    TopAppBar(
        title = {
            TopBarExample(topBarTitle)
        }
    )
}

@Preview
@Composable
fun TopBarComponentPreview() {
    TopBarComponent(topBarTitle = "Titulo de ejemplo")
}