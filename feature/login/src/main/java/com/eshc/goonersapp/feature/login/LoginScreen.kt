package com.eshc.goonersapp.feature.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.component.GnrTextFiled
import com.eshc.goonersapp.core.designsystem.component.TopBar

@Composable
fun LoginScreen(
    onShowSnackbar: (String) -> Unit,
    onClickSignUp : () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            title = "LOGIN",
            onBackIconClick = {}
        )

        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
                .size(128.dp),
            painter = painterResource(
                id = com.eshc.goonersapp.core.designsystem.R.drawable.app_logo
            ),
            contentDescription = null
        )


        GnrTextFiled(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                .height(40.dp),
            message = "",
            onValueChange = {

            },
            placeholder = "E-Mail"
        )
        GnrTextFiled(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                .height(40.dp),
            message = "",
            onValueChange = {

            },
            placeholder = "Password"
        )
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(40.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(0xFF151D2D)
            ),
            onClick = {


        }) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
            )
        }
        TextButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .height(40.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(0xFF151D2D)
            ),
            onClick = {
                onClickSignUp()

            }) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        onShowSnackbar = {},
        onClickSignUp = {}
    )
}