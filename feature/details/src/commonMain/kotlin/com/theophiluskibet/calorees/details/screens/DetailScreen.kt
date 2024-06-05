package com.theophiluskibet.calorees.details.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Text(text = name.capitalize())
                },
                backgroundColor = MaterialTheme.colors.surface,
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
                Column(modifier = Modifier.testTag("caloree_details")) {
                    Row {
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Calories",
                            value = "${caloreeUiState.data.calories}",
                            unit = "kcal",
                        )
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Proteins",
                            value = "${caloreeUiState.data.proteinGrams}",
                            unit = "grams",
                        )
                    }
                    Row {
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Carbohydrates",
                            value = "${caloreeUiState.data.carbohydratesTotalGrams}",
                            unit = "grams",
                        )
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Fats",
                            value = "${caloreeUiState.data.fatTotalGrams}",
                            unit = "grams",
                        )
                    }
                    Row {
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Sodium",
                            value = "${caloreeUiState.data.sodiumMilliGrams}",
                            unit = "grams",
                        )
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Sugar",
                            value = "${caloreeUiState.data.sugarGrams}",
                            unit = "grams",
                        )
                    }
                    Row {
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Cholestrol",
                            value = "${caloreeUiState.data.cholesterolMilliGrams}",
                            unit = "grams",
                        )
                        DetailItem(
                            modifier = Modifier.weight(1f),
                            borderStroke = BorderStroke(width = 0.5.dp, color = Color.Black),
                            title = "Fiber",
                            value = "${caloreeUiState.data.fiberGrams}",
                            unit = "grams",
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
    unit: String,
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
                    .background(Color(0xFFE9B969))
                    .padding(8.dp),
        ) {
            Text(text = title)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text =
                    buildAnnotatedString {
                        withStyle(
                            style =
                                SpanStyle(
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 36.sp,
                                ),
                        ) {
                            append(value)
                        }
                        append(" ")
                        append(unit)
                    },
            )
        }
    }
}
