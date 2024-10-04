package com.mexiti.dogphotoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mexiti.dogphotoapp.ui.DogApp
import com.mexiti.dogphotoapp.ui.DogApp
import com.mexiti.dogphotoapp.ui.theme.DogPhotoAppTheme
import com.mexiti.dogphotoapp.ui.theme.DogPhotoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogPhotoAppTheme {
                //Initial App without Model
                DogApp()
            }
        }
    }
}

