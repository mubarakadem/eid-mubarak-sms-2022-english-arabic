package com.iia.eidmubaraksms2022englisharabic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iia.eidmubaraksms2022englisharabic.ui.home.NavGraphs
import com.iia.eidmubaraksms2022englisharabic.ui.theme.EidMubarakSMS2022EnglishArabicTheme
import com.ramcosta.composedestinations.DestinationsNavHost

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EidMubarakSMS2022EnglishArabicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   SetUpNavHost()
                }
            }
        }
    }


}
@ExperimentalMaterial3Api
@Composable
private fun SetUpNavHost() {
    DestinationsNavHost(navGraph = NavGraphs.root)
}