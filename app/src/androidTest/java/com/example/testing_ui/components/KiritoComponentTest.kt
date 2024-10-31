package com.example.testing_ui.components

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelectable
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
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

        //Assertions
        composeTestRule.onNodeWithText("kirito").assertExists()
        composeTestRule.onNodeWithText("kirito").assertDoesNotExist()
        composeTestRule.onNodeWithText("kirito").assertContentDescriptionEquals("Hello")
        composeTestRule.onNodeWithText("kirito").assertContentDescriptionContains("Hello")
        composeTestRule.onNodeWithText("kirito").assertIsDisplayed() // Check if it's visible
        composeTestRule.onNodeWithText("kirito").assertIsNotDisplayed() // Check if it is not visible
        composeTestRule.onNodeWithText("kirito").assertIsEnabled() // Enabled textView or button
        composeTestRule.onNodeWithText("kirito").assertIsNotEnabled()
        composeTestRule.onNodeWithText("kirito").assertIsSelected() // Example RadioButton if it's selected
        composeTestRule.onNodeWithText("kirito").assertIsNotSelected()
        composeTestRule.onNodeWithText("kirito").assertIsFocused() // Example when you focus something on the textView
        composeTestRule.onNodeWithText("kirito").assertIsNotFocused()
        composeTestRule.onNodeWithText("kirito").assertIsOn()  // For the checked attribute
        composeTestRule.onNodeWithText("kirito").assertIsOff()
        composeTestRule.onNodeWithText("kirito").assertTextEquals("")
        composeTestRule.onNodeWithText("kirito").assertTextContains("Kirito")

    }

    @Test
    fun verifyComponentStartWithKirito(){
        composeTestRule.setContent { KiritoComponent() }

        composeTestRule.onNodeWithText("kirito", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Kirito")
    }
    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting(){
        composeTestRule.setContent { KiritoComponent() }

        composeTestRule.onNodeWithTag("textFieldName").performTextReplacement("Dur")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Your name is Dur")
    }

}