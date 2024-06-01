package com.theophiluskibet.calorees.calorees.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.theophilus.kibet.caloree.data.model.Caloree
import com.theophiluskibet.caloree.designsystem.components.EmptyScreenComponent
import com.theophiluskibet.caloree.designsystem.components.LoadingComponent
import com.theophiluskibet.calorees.calorees.utils.UiState
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun CaloreesScreen(
    modifier: Modifier = Modifier,
    viewModel: CaloreesViewModel = koinViewModel(),
    onNavigateToDetails: (String) -> Unit,
) {
    var searchString by remember { mutableStateOf("") }
    val caloryUiState by viewModel.caloriesState.collectAsState()

    Scaffold(
        topBar = {
            Column(
                modifier =
                Modifier
                    .background(MaterialTheme.colors.surface)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
            ) {
                Text("Calories")
                OutlinedTextField(
                    value = searchString,
                    onValueChange = {
                        searchString = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(text = "Search for food")
                    },
                    trailingIcon = {
                        IconButton(onClick = {
                            viewModel.getCalories(searchString)
                            searchString = ""
                        }) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "")
                        }
                    },
                    singleLine = true,
                    colors =
                    TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colors.onBackground,
                        disabledLabelColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colors.background,
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions =
                    KeyboardActions(onSearch = {
                        viewModel.getCalories(searchString)
                        searchString = ""
                    }),
                )
            }
        },
    ) { innerPadding ->
        CaloreeListSection(
            uiState = caloryUiState,
            onNavigateToDetails = onNavigateToDetails,
        )
    }
}

@Composable
fun CaloreeListSection(
    uiState: UiState,
    onNavigateToDetails: (String) -> Unit,
) {
    when (uiState) {
        is UiState.Error -> {
            EmptyScreenComponent(text = uiState.errorMessage)
        }

        is UiState.Loading -> LoadingComponent()
        is UiState.Default -> EmptyScreenComponent(text = "No data, Please search")
        is UiState.Success -> {
            if (uiState.data!!.isEmpty()) {
                EmptyScreenComponent(text = "No data, Please search")
            } else {
                Column(modifier = Modifier.fillMaxSize()) {
                    LazyColumn {
                        items(uiState.data) {
                            CaloreeCard(
                                caloryItem = it,
                                onNavigateToDetails = onNavigateToDetails,
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CaloreeCard(
    caloryItem: Caloree,
    onNavigateToDetails: (String) -> Unit,
) {
    Card(
        elevation = 10.dp,
        modifier = Modifier.padding(10.dp).fillMaxWidth(),
        onClick = {
            onNavigateToDetails(caloryItem.name)
        },
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = "Name: ${caloryItem.name}")
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Calories: ${caloryItem.calories}")
        }
    }
}
