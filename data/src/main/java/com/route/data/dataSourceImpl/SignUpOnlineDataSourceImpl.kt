package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.api.model.response.SignUpRequest
import com.route.data.dataSourcesContract.SignUpOnlineDataSource
import com.route.data.executeApi
import com.route.domain.model.ApiResult
import com.route.domain.model.SignUpData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) : SignUpOnlineDataSource {

    override fun signUp(
        email: String,
        password: String,
        userName: String,
        mobileNum: String
    ): Flow<ApiResult<SignUpData?>> {
        return executeApi {
            webServices.signUp(SignUpRequest(email, password, userName, mobileNum)).toSignUpData()
        }
    }
}