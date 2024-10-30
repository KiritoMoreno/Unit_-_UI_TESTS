package com.example.testing_ui.components

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
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

        //Finder
        composeTestRule.onNodeWithText("kirito", ignoreCase = true)
        composeTestRule.onNodeWithTag("component3")
        composeTestRule.onNodeWithContentDescription("superImage")

        composeTestRule.onAllNodesWithText(":") // it will search by letter or simbol
        composeTestRule.onAllNodesWithTag("component1") // it will take all nodes that has the same ID
        composeTestRule.onAllNodesWithContentDescription("VisualIcon")  // ti will search any type of view: (Decoration,button, etc..)
    }

}