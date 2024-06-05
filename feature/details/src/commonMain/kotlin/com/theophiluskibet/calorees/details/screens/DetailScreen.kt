package com.theophiluskibet.calorees.details.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
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
    onNavigateToBack: () -> Unit,
) {
    LaunchedEffect(key1 = true) {
        viewModel.getCaloreeDetails(food = name)
    }

    val caloreeUiState = viewModel.caloreeUiState.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onNavigateToBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "",
                        )
                    }
                },
                title = {
                },
                modifier = Modifier.background(Color.LightGray),
            )
        },
    ) { innerPadding ->
        DetailScreenContent(caloreeUiState = caloreeUiState)
    }
}

@Composable
fun DetailScreenContent(
    modifier: Modifier = Modifier,
    caloreeUiState: DetailsUiState,
) {
    Column {
        when (caloreeUiState) {
            is DetailsUiState.Loading -> LoadingComponent()
            is DetailsUiState.Error -> {
                EmptyScreenComponent(text = caloreeUiState.errorMessage)
            }

            is DetailsUiState.Success -> {
                Column(modifier=Modifier.testTag("caloree_details")) {
                    Row {
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Calories",
                            value = "${caloreeUiState.data.calories}kcal",
                        )
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Proteins",
                            value = "${caloreeUiState.data.proteinGrams}grams",
                        )
                    }
                    Row {
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Carbohydrates",
                            value = "${caloreeUiState.data.carbohydratesTotalGrams}grams",
                        )
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Fats",
                            value = "${caloreeUiState.data.fatTotalGrams}grams",
                        )
                    }
                }
            }

            is DetailsUiState.Default -> {
                // do nothing
            }
        }
    }
}

@Composable
fun DetailItem(
    modifier: Modifier,
    borderStroke: BorderStroke,
    title: String,
    value: String,
) {
    Card(
        modifier =
            modifier
                .padding(8.dp),
        border = borderStroke,
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.surface)
                    .padding(16.dp),
        ) {
            Text(text = title)
            Text(text = value)
        }
    }
}
