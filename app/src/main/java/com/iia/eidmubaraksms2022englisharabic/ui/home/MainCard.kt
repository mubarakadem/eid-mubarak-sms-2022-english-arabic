package com.iia.eidmubaraksms2022englisharabic.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun MainCard(
    modifier: Modifier = Modifier,
    title: String? = null,
    actionText: String? = "View",
    actionPerform: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            title?.let {
                Text(
                    text = it,
                    fontSize = MaterialTheme.typography.displaySmall.fontSize,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }

            Box(Modifier.weight(1f)) {
                content()
            }

            Divider(
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.5f),
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TextButton(onClick = actionPerform, modifier = Modifier.align(Alignment.End)) {
                actionText?.let { Text(text = it) }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MainCardPreview() {
    MainCard(title = "Recent", actionPerform = {}) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Something")
        }
    }
}