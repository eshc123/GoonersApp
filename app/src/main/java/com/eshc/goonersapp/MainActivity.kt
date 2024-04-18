package com.eshc.goonersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eshc.goonersapp.core.data.util.NetworkConnectivityManager
import com.eshc.goonersapp.core.designsystem.theme.GoonersAppTheme
import com.eshc.goonersapp.ui.GnrApp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkConnectivityManager: NetworkConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoonersAppTheme {
                GnrApp(networkConnectivityManager)
            }
        }
    }
}