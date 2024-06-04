package com.theophiluskibet.caloree.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun EmptyScreenComponent(text: String) {
    Box(modifier = Modifier.fillMaxSize().testTag("empty_component"), contentAlignment = Alignment.Center) {
        Text(text = text)
    }
}
