package com.eshc.goonersapp.core.domain.usecase.user

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(
        email: String,
        password: String,
        nickname: String,
        teamId: Int
    ): Flow<DataResult<String>> =
        userRepository.signUp(email, password,nickname,teamId)
}