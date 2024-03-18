package com.eshc.goonersapp.core.network.api

import com.eshc.goonersapp.core.network.model.BaseResponse
import com.eshc.goonersapp.core.network.model.user.RemoteLoginInfo
import com.eshc.goonersapp.core.network.model.user.body.CheckEmailBody
import com.eshc.goonersapp.core.network.model.user.body.LoginBody
import com.eshc.goonersapp.core.network.model.user.body.SignUpBody
import com.eshc.goonersapp.core.network.model.user.body.VerifyEmailBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

const val USER_BASE_URL = "/apis/user"
interface UserNetworkService {

    @POST(value = "$USER_BASE_URL/email")
    suspend fun checkEmail(
        @Body body : CheckEmailBody
    ) : Response<BaseResponse<String>>

    @POST(value = "$USER_BASE_URL/email/verification")
    suspend fun verifyEmail(
        @Body body : VerifyEmailBody
    ) : Response<BaseResponse<String>>

    @POST(value = USER_BASE_URL)
    suspend fun signUp(
        @Body body : SignUpBody
    ) : Response<BaseResponse<String>>

    @POST(value = "$USER_BASE_URL/login")
    suspend fun login(
        @Body body : LoginBody
    ) : Response<BaseResponse<RemoteLoginInfo>>
}
