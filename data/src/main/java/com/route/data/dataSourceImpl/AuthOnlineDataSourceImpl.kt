package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.api.model.request.Auth.LoginRequest
import com.route.data.api.model.request.Auth.SignUpRequest
import com.route.data.dataSourcesContract.AuthOnlineDataSource
import com.route.data.executeApi
import com.route.domain.model.ApiResult
import com.route.domain.model.AuthData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
): AuthOnlineDataSource {

    override fun login(email: String, password: String): Flow<ApiResult<AuthData?>> {
        return executeApi {
            webServices.login(LoginRequest(email,password))
                .toLoginData()
        }
    }
    override fun signUp(
        email: String,
        password: String,
        userName: String,
        mobileNum: String
    ): Flow<ApiResult<AuthData?>> {
        return executeApi {
            webServices.signUp(
                SignUpRequest(
                email = email,
                password = password,
                name = userName,
                phone = mobileNum,
                rePassword = password
            )
            ).toSignUpData()
        }
    }
}