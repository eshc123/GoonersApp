package com.eshc.goonersapp.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.goonersapp.core.domain.usecase.user.CheckEmailUseCase
import com.eshc.goonersapp.core.domain.usecase.user.VerifyEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val checkEmailUseCase: CheckEmailUseCase,
    private val verifyEmailUseCase: VerifyEmailUseCase
) : ViewModel() {

    private val _signUpInputTypeList = MutableStateFlow(listOf(SignUpInputType.Email))
    val signUpInputTypeList : StateFlow<List<SignUpInputType>> = _signUpInputTypeList.asStateFlow()

    private val _email = MutableStateFlow("")
    val email : StateFlow<String> = _email.asStateFlow()

    private val _emailCode = MutableStateFlow("")
    val emailCode : StateFlow<String> = _emailCode.asStateFlow()

    fun nextToSignUpStep() {
        viewModelScope.launch {
            signUpInputTypeList.value.last().getNextType().let { nextType ->
                when(nextType){
                    SignUpInputType.EmailAuth -> {
                        checkEmailUseCase(email.value)
                            .collect {
                                changeToNextStep(nextType)
                            }
                    }
                    SignUpInputType.Password -> {
                        verifyEmailUseCase(email.value,emailCode.value)
                            .collect{
                                changeToNextStep(nextType)
                            }
                    }
                    else -> {

                    }
                }

            }
        }
    }

    private fun changeToNextStep(nextType: SignUpInputType?) {
        if(nextType != null) _signUpInputTypeList.value = signUpInputTypeList.value + nextType
        else {
            // TODO Sign UP
        }
    }

    fun isCurrentType(type: SignUpInputType) : Boolean{
        return signUpInputTypeList.value.lastOrNull()?.let {
            it == type
        } ?: false
    }

    fun updateEmail(email : String){
        _email.value = email
    }

    fun updateEmailCode(emailCode : String){
        _emailCode.value = emailCode
    }
}

enum class SignUpInputType {
    Email, EmailAuth, Password, PasswordCheck, Nickname
}

fun SignUpInputType.getNextType() : SignUpInputType? {
    return SignUpInputType.entries.getOrNull(this.ordinal + 1)
}