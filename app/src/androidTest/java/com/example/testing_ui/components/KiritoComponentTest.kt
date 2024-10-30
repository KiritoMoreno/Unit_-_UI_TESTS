package com.example.testing_ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class KiritoComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest(){
        composeTestRule.setContent {
            KiritoComponent()
        }
    }
    
}