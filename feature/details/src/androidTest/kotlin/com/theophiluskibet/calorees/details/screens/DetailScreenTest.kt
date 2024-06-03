package com.theophiluskibet.calorees.details.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldShowLoadingOnInitialization() {
        composeTestRule.setContent {
            MaterialTheme {
                DetailScreen(
                    name = "rice",
                    onNavigateToBack = {},
                )
            }
            composeTestRule.onNodeWithTag("loading").assertIsDisplayed()
        }
    }
}
