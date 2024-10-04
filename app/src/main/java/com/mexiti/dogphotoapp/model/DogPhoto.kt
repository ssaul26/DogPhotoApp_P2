package com.mexiti.dogphotoapp.model

import kotlinx.serialization.Serializable

@Serializable
data class DogPhoto(
    val id:String,
    val url:String,
    val width: Int,
    val height:Int,
)
