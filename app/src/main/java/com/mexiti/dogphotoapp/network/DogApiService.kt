package com.mexiti.dogphotoapp.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mexiti.dogphotoapp.model.DogPhoto
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


private const val BASE_URL = "https://api.thedogapi.com/" //es la base para todas las solicitudes a la api

private val retrofit = Retrofit.Builder()//Se utiliza para crear y configurar las solicitudes HTTP
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) //Convierte las respuestas JSON en Kotlin
    .baseUrl(BASE_URL)  //establece la URL base
    .build() //finaliza la configuracion de Retrofit

interface DogApiService{  //Define los metodos para realizar las solicitudes a la API
    @GET("v1/images/search?limit=10")
    suspend fun getPhotos():List<DogPhoto> //Obtiene una lista de fotos de perros
}

object DogApi {
    val retrofitService: DogApiService by lazy{ //la inicializacion de retrofitService se posterga hasta que accede por primera vez
        retrofit.create(DogApiService::class.java) //utiliza la instanca Retrofit para crear la implementacion de la interfaz "DogApiService"
    }
}