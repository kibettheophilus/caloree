package com.theophiluskibet.caloree.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.testTag
import caloree.core.designsystem.generated.resources.Res
import caloree.core.designsystem.generated.resources.empty_data
import org.jetbrains.compose.resources.painterResource

@Composable
fun EmptyScreenComponent(text: String) {
    Box(
        modifier = Modifier.fillMaxSize().testTag("empty_component"),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                modifier = Modifier.size(250.dp).padding(bottom = 10.dp),
                painter = painterResource(Res.drawable.empty_data),
                contentDescription = ""
            )
            Text(text = text)
        }
    }
}
