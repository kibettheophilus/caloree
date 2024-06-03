package com.theophiluskibet.calorees.details.screens

import com.theophiluskibet.calorees.details.utils.DetailsUiState
import com.theophiluskibet.calorees.details.utils.FakeCaloreeRepository
import com.theophiluskibet.calorees.details.utils.searchData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class DetailsViewModelTest {
    private val repository = FakeCaloreeRepository()
    private lateinit var detailsViewModel: DetailsViewModel

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        detailsViewModel = DetailsViewModel(repository = repository)
    }

    @AfterTest
    fun clean() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given DetailsViewModel- initial details ui state is default`() =
        runTest {
            assertEquals(detailsViewModel.caloreeUiState.value, DetailsUiState.Default)
        }

    @Test
    fun `given string of food - when getCalireeDetails is invoked - then details ui state is loading`() =
        runTest {
            // given
            val food = "rice"

            // when
            detailsViewModel.getCaloreeDetails(food)

            // then
            assertEquals(DetailsUiState.Loading, detailsViewModel.caloreeUiState.value)
        }

    @Test
    fun `given string of food - when getCalireeDetails is success - then details ui state is success with data`() =
        runTest {
            // given
            val food = "rice"

            // when
            detailsViewModel.getCaloreeDetails(food)
            advanceUntilIdle()

            // then
            assertEquals(
                DetailsUiState.Success(data = searchData.first()),
                detailsViewModel.caloreeUiState.value,
            )
        }

    @Test
    fun `given string of food - when getCalireeDetails is error - then details ui state is error with message`() =
        runTest {
            // simulate error in the repository
            repository.shouldThrowError = true
            // given
            val food = "rice"

            // when
            detailsViewModel.getCaloreeDetails(food)
            advanceUntilIdle()

            // then
            assertEquals(
                DetailsUiState.Error(errorMessage = "An error occured"),
                detailsViewModel.caloreeUiState.value,
            )
        }
}
