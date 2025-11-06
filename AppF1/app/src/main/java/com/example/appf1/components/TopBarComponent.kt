package com.example.appf1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.appf1.R

@Composable
fun TopBarExample(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, textAlign = TextAlign.Center)
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Ejemplo"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    topBarTitle: String,
    navIcon: () -> Unit = {},
    infoIcon: () -> Unit = {}
) {

    TopAppBar(
        title = {
            TopBarExample(topBarTitle)
        },
        navigationIcon = {
            IconButton(
                onClick = navIcon
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver Atras",
                )
            }
        },
        actions = {
            IconButton(
                onClick = infoIcon
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Volver Atras",
                )
            }
        }
    )
}

@Preview
@Composable
fun TopBarComponentPreview() {
    TopBarComponent(topBarTitle = "Prueba ")
}