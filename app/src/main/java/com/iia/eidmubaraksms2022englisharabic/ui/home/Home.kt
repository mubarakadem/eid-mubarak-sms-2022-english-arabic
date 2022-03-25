package com.iia.eidmubaraksms2022englisharabic.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination

@ExperimentalMaterial3Api
@Destination(start = true)
@Composable
fun Home() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = { Text(text = "Home") })
    }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                MainCard(title = "Recent", actionPerform = { }) {
                    Text(text = "6 Items")
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun HomePreview() {
    Home()
}