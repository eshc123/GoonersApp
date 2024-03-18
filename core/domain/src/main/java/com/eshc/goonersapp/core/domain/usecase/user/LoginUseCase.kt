package com.eshc.goonersapp.core.domain.usecase.user

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.user.LoginInfo
import com.eshc.goonersapp.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(
        email: String,
        password: String,
        deviceToken: String
    ): Flow<DataResult<LoginInfo>> =
        userRepository.login(email, password,deviceToken)
}