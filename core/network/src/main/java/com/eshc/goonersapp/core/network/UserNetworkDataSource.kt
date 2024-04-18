package com.eshc.goonersapp.core.network

import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.user.RemoteLoginInfo
import com.eshc.goonersapp.core.network.model.user.body.CheckEmailBody
import com.eshc.goonersapp.core.network.model.user.body.LoginBody
import com.eshc.goonersapp.core.network.model.user.body.SignUpBody
import com.eshc.goonersapp.core.network.model.user.body.VerifyEmailBody

interface UserNetworkDataSource {
    suspend fun checkEmail(body: CheckEmailBody) : NetworkResult<String>

    suspend fun verifyEmail(body: VerifyEmailBody) : NetworkResult<String>

    suspend fun signUp(body: SignUpBody) : NetworkResult<String>

    suspend fun login(body: LoginBody) : NetworkResult<RemoteLoginInfo>

}