package com.theophiluskibet.calorees.details.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.theophiluskibet.caloree.designsystem.components.EmptyScreenComponent
import com.theophiluskibet.caloree.designsystem.components.LoadingComponent
import com.theophiluskibet.calorees.details.utils.DetailsUiState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    name: String,
    viewModel: DetailsViewModel = koinViewModel(),
    onNavigateToBack: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        viewModel.getCaloreeDetails(food = name)
    }

    val caloreeUiState = viewModel.caloreeUiState.collectAsState().value

    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            IconButton(onClick = onNavigateToBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = ""
                )
            }

        }, title = {

        },
            modifier = Modifier.background(Color.LightGray)
        )
    }
    ) { innerPadding ->

        Column {
            when (caloreeUiState) {
                is DetailsUiState.Loading -> LoadingComponent()
                is DetailsUiState.Error -> {
                    EmptyScreenComponent(text = caloreeUiState.errorMessage)
                }

                is DetailsUiState.Success -> {
                    Column(
                        modifier =
                        Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text("${caloreeUiState.data.calories}")
                    }
                }

                is DetailsUiState.Default -> {
                    //do nothing
                }
            }
        }

    }
}
