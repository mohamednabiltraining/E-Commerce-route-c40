package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.api.model.response.LoginResponse
import com.route.data.dataSourcesContract.LoginOnlineDataSource
import com.route.domain.model.LoginData
import javax.inject.Inject

class LoginOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
): LoginOnlineDataSource {

    override suspend fun login(email: String, password: String): List<LoginData>? {
        val response = webServices.login(LoginResponse(email))
        return null
    }
}