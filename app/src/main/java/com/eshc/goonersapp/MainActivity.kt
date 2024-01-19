package com.eshc.goonersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eshc.goonersapp.core.designsystem.theme.GoonersAppTheme
import com.eshc.goonersapp.ui.GnrApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoonersAppTheme {
                // A surface container using the 'background' color from the theme
                GnrApp()
            }
        }
    }
}