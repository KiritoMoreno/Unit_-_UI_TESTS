package com.example.testing_ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun KiritoComponent(){
    //
    Column (Modifier.fillMaxSize()){
        Text(text = "KIRITO", Modifier.testTag("component1"))
        Text(text = "PEDRO", Modifier.testTag("component2"))
        Text(text = "KIRITO",Modifier.testTag("component3"))

        Image(Icons.Default.Add, contentDescription = "superImage")
    }
}