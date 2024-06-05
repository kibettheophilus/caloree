package com.theophiluskibet.calorees.calorees.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.theophiluskibet.calorees.calorees.utils.CaloreesUiState
import com.theophiluskibet.calorees.calorees.utils.caloreeList
import org.junit.Rule
import org.junit.Test

class CaloreesScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldShowEmptyComponentOnInitialization() {
        composeTestRule.setContent {
            MaterialTheme {
                CaloreeListSection(
                    caloreesUiState = CaloreesUiState.Default,
                    onNavigateToDetails = {},
                )
            }
        }

        composeTestRule.onNodeWithTag("empty_component").isDisplayed()
    }

    @Test
    fun shouldShowLoadingComponentDuringSearch() {
        composeTestRule.setContent {
            MaterialTheme {
                CaloreeListSection(
                    caloreesUiState = CaloreesUiState.Loading,
                    onNavigateToDetails = {}
                )
            }
        }

        composeTestRule.onNodeWithTag("loading").isDisplayed()
        composeTestRule.onNodeWithTag("empty_component").isNotDisplayed()
    }

    @Test
    fun shouldShowEmptyComponentOnError() {
        composeTestRule.setContent {
            MaterialTheme {
                CaloreeListSection(
                    caloreesUiState = CaloreesUiState.Error(errorMessage = "An error occured"),
                    onNavigateToDetails = {},
                )
            }
        }

        composeTestRule.onNodeWithTag("empty_component").isDisplayed()
        composeTestRule.onNodeWithText("An error occured").isNotDisplayed()
        composeTestRule.onNodeWithTag("loading").isNotDisplayed()
    }

    @Test
    fun shouldShowLazyColumnOnSucess() {
        composeTestRule.setContent {
            MaterialTheme {
                CaloreeListSection(
                    caloreesUiState = CaloreesUiState.Success(data = caloreeList),
                    onNavigateToDetails = {}
                )
            }
        }
        composeTestRule.onNodeWithTag("caloree_list").isDisplayed()
        composeTestRule.onNodeWithTag("empty_component").isNotDisplayed()
        composeTestRule.onNodeWithText("An error occured").isNotDisplayed()
        composeTestRule.onNodeWithTag("loading").isNotDisplayed()
    }
}
