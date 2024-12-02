package com.example.testing_ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class DialogComponentTests{

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetATrue_then_showDialog(){
        composeTestRule.setContent {
            //Here wi will need the lambda but we can check without it
            AddTasksDialog(show = true, onDismiss = {  }, onTaskAdded = {})
        }
        composeTestRule.onNodeWithTag("diolog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetAFalse_then_doNotShowDialog(){
        composeTestRule.setContent {
            //Here wi will need the lambda but we can check without it
            AddTasksDialog(show = false, onDismiss = {  }, onTaskAdded = {})
        }
        composeTestRule.onNodeWithTag("diolog").assertDoesNotExist()
    }
}