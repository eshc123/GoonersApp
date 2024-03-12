package com.eshc.goonersapp.feature.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ViewModel() {

    private val _signUpInputTypeList = MutableStateFlow(listOf(SignUpInputType.Email))
    val signUpInputTypeList : StateFlow<List<SignUpInputType>> = _signUpInputTypeList.asStateFlow()

    fun nextToSignUpStep() {
        signUpInputTypeList.value.last().getNextType().let { nextType ->
            if(nextType != null) _signUpInputTypeList.value = signUpInputTypeList.value + nextType
            else {
                // TODO Sign UP
            }
        }
    }

}

enum class SignUpInputType {
    Email, EmailAuth, Password, PasswordCheck, Nickname
}

fun SignUpInputType.getNextType() : SignUpInputType? {
    return SignUpInputType.entries.getOrNull(this.ordinal + 1)
}