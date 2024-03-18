package com.eshc.goonersapp.core.network.remote

import com.eshc.goonersapp.core.network.UserNetworkDataSource
import com.eshc.goonersapp.core.network.api.UserNetworkService
import com.eshc.goonersapp.core.network.model.NetworkResult
import com.eshc.goonersapp.core.network.model.handleApi
import com.eshc.goonersapp.core.network.model.user.RemoteLoginInfo
import com.eshc.goonersapp.core.network.model.user.body.CheckEmailBody
import com.eshc.goonersapp.core.network.model.user.body.LoginBody
import com.eshc.goonersapp.core.network.model.user.body.SignUpBody
import com.eshc.goonersapp.core.network.model.user.body.VerifyEmailBody
import javax.inject.Inject

class UserNetworkDataSourceImpl @Inject constructor(
    private val userNetworkService: UserNetworkService
) : UserNetworkDataSource{
    override suspend fun checkEmail(body: CheckEmailBody): NetworkResult<String> {
        return handleApi {
            userNetworkService.checkEmail(body)
        }
    }

    override suspend fun verifyEmail(body: VerifyEmailBody): NetworkResult<String> {
        return handleApi {
            userNetworkService.verifyEmail(body)
        }
    }

    override suspend fun signUp(body: SignUpBody): NetworkResult<String> {
        return handleApi {
            userNetworkService.signUp(body)
        }
    }

    override suspend fun login(body: LoginBody): NetworkResult<RemoteLoginInfo> {
        return handleApi {
            userNetworkService.login(body)
        }
    }
}