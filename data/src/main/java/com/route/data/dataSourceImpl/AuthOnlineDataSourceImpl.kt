package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.api.model.response.LoginRequest
import com.route.data.dataSourcesContract.AuthOnlineDataSource
import com.route.data.executeApi
import com.route.domain.model.ApiResult
import com.route.domain.model.LoginData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
): AuthOnlineDataSource {

    override fun login(email: String, password: String): Flow<ApiResult<LoginData?>> {
        return executeApi {
            webServices.login(LoginRequest(email,password))
                .toLoginData()
        }
    }
}