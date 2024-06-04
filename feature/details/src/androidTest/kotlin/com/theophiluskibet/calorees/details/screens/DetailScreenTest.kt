package com.theophiluskibet.calorees.details.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.theophiluskibet.calorees.details.utils.DetailsUiState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldShowLoadingOnInitialization() {
        composeTestRule.setContent {
            MaterialTheme {
                DetailScreenContent(
                    caloreeUiState = DetailsUiState.Loading,
                )
            }
            composeTestRule.onNodeWithTag("loading").assertIsDisplayed()
        }
    }
}
