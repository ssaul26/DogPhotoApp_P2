package com.mexiti.dogphotoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.dogphotoapp.model.DogPhoto
import com.mexiti.dogphotoapp.network.DogApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface DogUiState{ //Define los diferentes estados posibles para la interfaz
    data class Success(val photos:List<DogPhoto>) : DogUiState //cuando la app carga correctamente
    object Error: DogUiState //Cuando se rechazo la peticion
    object Loading: DogUiState //Cuando se esta cargando o haciendo la peticion
}
class DogViewModel:ViewModel(){ //Se encarga de conservar y administrar los dator relacionados con la interfaz
    var dogUiState:DogUiState  by mutableStateOf(DogUiState.Loading) //Almacena un valor mutable que desencadenara recomposiciones cuando cambie
        private set

    init{ //se llama a getdogphotos para inciar la carga de fotos de perros
        getDogPhotos()
    }

   private  fun getDogPhotos(){ //es la funcion responables de hacer la solicitud a la API
         viewModelScope.launch {
            dogUiState = try {
                 val listResult = DogApi.retrofitService.getPhotos()
                DogUiState.Success( listResult)
             } catch (e: IOException){
                 DogUiState.Error
             }

         }
    }

}