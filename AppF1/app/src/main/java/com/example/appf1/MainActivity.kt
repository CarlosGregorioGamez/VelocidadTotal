package com.example.appf1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.TopBarComponent
import com.example.appf1.pages.MainList
import com.example.compose.AppF1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val testList = mutableListOf<CardSliderDetails>()

            (1..10).forEach {
                testList.add(
                    CardSliderDetails(
                        imgId = R.drawable.calendario_carreras,
                        imgDesc = "Descripción #$it",
                        title = "Elemento $it"
                    )
                )
            }
            AppF1Theme {
                Scaffold(
                    topBar = {
                        TopBarComponent(
                            topBarTitle = "Menú principal",
                            navIcon = {

                            },
                            burguerIcon = {
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MainList(
                        races = testList,
                        drivers = testList,
                        teams = testList,
                        titlePage = "Pagina principal",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainListPreview() {
    AppF1Theme {
        val testList = mutableListOf<CardSliderDetails>()

        (1..10).forEach {
            testList.add(
                CardSliderDetails(
                    imgId = R.drawable.calendario_carreras,
                    imgDesc = "Descripción #$it",
                    title = "Elemento $it"
                )
            )
        }
        MainList(
            races = testList,
            drivers = testList,
            teams = testList,
            titlePage = "Pagina principal",
            modifier = Modifier)
    }
}