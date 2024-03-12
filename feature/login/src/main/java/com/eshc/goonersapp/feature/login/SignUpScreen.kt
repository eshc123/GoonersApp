package com.eshc.goonersapp.feature.login

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.eshc.goonersapp.core.designsystem.component.GnrTextFiled
import com.eshc.goonersapp.core.designsystem.component.TopBar
import com.eshc.goonersapp.core.designsystem.theme.pretendard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignUpScreen(
    onShowSnackbar: (String) -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val inputTypeList by viewModel.signUpInputTypeList.collectAsStateWithLifecycle()
    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopBar(
                title = "Sign Up"
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(inputTypeList.reversed(), key = {
                    it
                }){
                    GnrTextFiled(
                        modifier = Modifier
                            .animateItemPlacement(
                                animationSpec = tween(
                                    durationMillis = 500,
                                    easing = LinearOutSlowInEasing
                                )
                            )
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                            .height(40.dp),
                        message = "",
                        onValueChange = {

                        },
                        placeholder = it.name
                    )
                }
            }



            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .height(40.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color(0xFF151D2D)
                ),
                onClick = {
                    viewModel.nextToSignUpStep()

                }) {
                Text(
                    text = "Next",
                    fontFamily = pretendard,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                )
            }

        }
    }

}

@Preview
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen(onShowSnackbar = {})
}