package com.route.data.dataSourceImpl

import com.route.data.api.WebServices
import com.route.data.api.model.response.User
import com.route.data.dataSourcesContract.LoginOnlineDataSource
import javax.inject.Inject

class LoginOnlineDataSourceImpl @Inject constructor(
    private val webServices: WebServices
): LoginOnlineDataSource {
    override suspend fun login(email: String, password: String): User? {
        val response = webServices.login(email, password)
        return response.user!!
    }
}
