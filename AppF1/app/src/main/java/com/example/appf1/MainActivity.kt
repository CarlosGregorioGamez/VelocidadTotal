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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appf1.components.CardSliderDetails
import com.example.appf1.components.TopBarComponent
import com.example.appf1.pages.MainMenu
import com.example.appf1.pages.pagePrincipal
import com.example.appf1.repository.UserRepostoryMemory
import com.example.appf1.viewmodel.vm.LoginVM
import com.example.appf1.viewmodel.vm.LoginVMFactory
import com.example.compose.AppF1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val repository = UserRepostoryMemory()
        val factory = LoginVMFactory(repository)
        val loginVM = ViewModelProvider(this, factory)[LoginVM::class.java]
        setContent {
            /**

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
                    MainMenu(
                        titlePage = "Pagina principal",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            **/

            pagePrincipal(loginVM)
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
        MainMenu(
            titlePage = "Pagina principal",
            modifier = Modifier
        )
    }
}