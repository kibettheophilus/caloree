package com.theophiluskibet.calorees.calorees.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class CaloreesScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldShowNothing() {
        composeTestRule.setContent {
            MaterialTheme {
                CaloreesScreen(
                    onNavigateToDetails = {},
                )
            }
        }

        composeTestRule.onNodeWithTag("empty_component").isDisplayed()
    }
}
