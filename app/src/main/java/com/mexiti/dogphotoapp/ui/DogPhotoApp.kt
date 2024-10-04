package com.mexiti.dogphotoapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mexiti.catphotoapp.R
import com.mexiti.dogphotoapp.ui.screens.HomeScreen
import com.mexiti.dogphotoapp.viewmodel.DogViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable //Se define la interfaz de usuario
fun DogApp(){ //llama la funcion CatApp
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior() //Llama a la barra superior
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
       topBar = { CatTopBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface( //utliza un lienzo para dibujar el contenido
            modifier = Modifier.fillMaxSize()) {
            val dogViewModel:DogViewModel = viewModel() //se proporcionan los datos para la pantalla
            HomeScreen(dogUiState = dogViewModel.dogUiState, contentPadding = it) // se recibe el estado actual de la interfaz y el relleno de contenido

        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatTopBar(scrollBehavior: TopAppBarScrollBehavior,modifier:Modifier = Modifier) //la funcion que define la barra superior
{

    CenterAlignedTopAppBar( //hace que la barra este centrada
        scrollBehavior = scrollBehavior,
        title = {
            Text( //se toma el nombre del programa y el estilo del texto
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium



            )
        }
    )

}