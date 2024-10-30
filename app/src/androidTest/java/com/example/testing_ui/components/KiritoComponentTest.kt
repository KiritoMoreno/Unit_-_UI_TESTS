package com.example.testing_ui.components

import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
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

        //Actions
        composeTestRule.onNodeWithText("kirito", ignoreCase = true).performClick() // it can be clickable the text
        composeTestRule.onAllNodesWithText("a").onFirst().performClick() //Take only one
        composeTestRule.onNodeWithText("kirito").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }  // To select the click
        composeTestRule.onNodeWithText("kirito").performScrollTo()  // Scroll inside the component
        composeTestRule.onNodeWithText("kirito").performImeAction()  // The button of action (Enter)
        composeTestRule.onNodeWithText("kirito").performTextClearance()  // Delete the Text of textField
        composeTestRule.onNodeWithText("kirito").performTextInput("Hellllllooooo")  // it will add to the TextField
        composeTestRule.onNodeWithText("kirito").performTextReplacement("Hello") // it will replace the text



    }

}