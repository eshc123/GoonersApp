package com.eshc.goonersapp.core.domain.usecase.user

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckEmailUseCase   @Inject constructor(
    private val userRepository: UserRepository
) {

    operator fun invoke(email: String): Flow<DataResult<String>> =
        userRepository.checkEmail(email)
}