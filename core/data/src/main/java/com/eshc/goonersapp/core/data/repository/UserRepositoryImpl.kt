package com.eshc.goonersapp.core.data.repository

import com.eshc.goonersapp.core.data.mapper.toDataResult
import com.eshc.goonersapp.core.data.mapper.toModel
import com.eshc.goonersapp.core.domain.model.DataResult
import com.eshc.goonersapp.core.domain.model.user.LoginInfo
import com.eshc.goonersapp.core.domain.repository.UserRepository
import com.eshc.goonersapp.core.network.UserNetworkDataSource
import com.eshc.goonersapp.core.network.model.user.body.CheckEmailBody
import com.eshc.goonersapp.core.network.model.user.body.LoginBody
import com.eshc.goonersapp.core.network.model.user.body.SignUpBody
import com.eshc.goonersapp.core.network.model.user.body.VerifyEmailBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource
) : UserRepository {
    override fun checkEmail(email: String): Flow<DataResult<String>> = flow {
        emit(userNetworkDataSource.checkEmail(
            CheckEmailBody(email)
        ).toDataResult(
            convert = {
                it
            }
        ))
    }

    override fun verifyEmail(email: String, code: String): Flow<DataResult<String>> = flow {
        emit(userNetworkDataSource.verifyEmail(
            VerifyEmailBody(email,code)
        ).toDataResult(
            convert = {
                it
            }
        ))
    }

    override fun signUp(
        email: String,
        password: String,
        nickname: String,
        teamId: Int
    ): Flow<DataResult<String>> = flow {
        emit(userNetworkDataSource.signUp(
            SignUpBody(email,password,nickname,teamId)
        ).toDataResult(
            convert = {
                it
            }
        ))
    }

    override fun login(
        email: String,
        password: String,
        deviceToken: String
    ): Flow<DataResult<LoginInfo>> = flow {
        emit(userNetworkDataSource.login(
            LoginBody(email,password,deviceToken)
        ).toDataResult(
            convert = {
                it.toModel()
            }
        ))
    }
}