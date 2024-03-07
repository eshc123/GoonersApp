package com.eshc.goonersapp.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eshc.goonersapp.core.designsystem.component.TopBar

@Composable
fun LoginScreen(
    onShowSnackbar : (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            title = "Login"
        )
    }
}

@Preview
@Composable
fun PreviewLoginScreen(){
    LoginScreen(onShowSnackbar = {})
}