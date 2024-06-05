package com.theophiluskibet.calorees.details.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.theophiluskibet.calorees.calorees.utils.caloreeDetails
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

    @Test
    fun shouldShowEmptyComponentOnError() {
        composeTestRule.setContent {
            MaterialTheme {
                DetailScreenContent(
                    caloreeUiState = DetailsUiState.Error(errorMessage = "An error occured")
                )
            }
        }
        composeTestRule.onNodeWithTag("empty_component").isDisplayed()
        composeTestRule.onNodeWithText("An error occured").isDisplayed()
        composeTestRule.onNodeWithTag("loading").isNotDisplayed()
        composeTestRule.onNodeWithTag("caloree_details").isNotDisplayed()
    }

    @Test
    fun shouldShowCaloreeDetailsOnSuccess() {
        composeTestRule.setContent {
            DetailScreenContent(
                caloreeUiState = DetailsUiState.Success(data = caloreeDetails)
            )
        }
        composeTestRule.onNodeWithTag("caloree_details").isDisplayed()
        composeTestRule.onNodeWithTag("empty_component").isNotDisplayed()
        composeTestRule.onNodeWithTag("loading").isNotDisplayed()
    }
}
