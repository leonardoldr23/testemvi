package br.com.testemvi.ds.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HeaderLarge (
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    modifier: Modifier = Modifier,
) {
    Text (
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        color = color,
        modifier = modifier,
    )
}