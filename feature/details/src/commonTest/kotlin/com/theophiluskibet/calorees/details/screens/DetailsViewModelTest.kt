package com.theophiluskibet.calorees.details.screens

import com.theophilus.kibet.caloree.data.sources.CaloreeRepositoryImpl
import com.theophiluskibet.calorees.details.utils.FakeCaloreeRepository
import kotlinx.coroutines.Dispatchers
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
        Dispatchers.setMain(Dispatchers.Unconfined)
        detailsViewModel = DetailsViewModel(repository = repository)
    }

    @AfterTest
    fun clean() {
        Dispatchers.resetMain()
    }

    @Test
    fun `sample test`() = runTest {
        val data = repository.searchCalories("meat")
        detailsViewModel.getCaloreeDetails("meat")
        assertEquals("meat", data.first().name)
    }
}