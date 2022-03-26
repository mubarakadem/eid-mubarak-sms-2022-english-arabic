package com.iia.eidmubaraksms2022englisharabic.ui.message

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination

@ExperimentalMaterial3Api
@Destination
@Composable
fun MessageList() {
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text(text = "Eid Mubarak SMS") }) }) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ){
            items(100){
                MessageItem()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MessageListPreview() {
    MessageList()
}