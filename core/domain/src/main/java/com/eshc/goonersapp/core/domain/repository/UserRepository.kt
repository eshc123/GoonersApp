package com.eshc.goonersapp.core.domain.repository

import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.user.LoginInfo
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun checkEmail(email: String): Flow<DataResult<String>>

    fun verifyEmail(email: String, code: String): Flow<DataResult<String>>

    fun signUp(
        email: String,
        password: String,
        nickname: String,
        teamId: Int
    ): Flow<DataResult<String>>

    fun login(
        email: String,
        password: String,
        deviceToken: String
    ): Flow<DataResult<LoginInfo>>
}