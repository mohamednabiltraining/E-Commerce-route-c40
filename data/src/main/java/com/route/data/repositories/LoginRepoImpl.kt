package com.route.data.repositories

import com.route.data.dataSourcesContract.LoginOnlineDataSource
import com.route.domain.model.LoginData
import com.route.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginRepoImpl @Inject constructor(
    private val loginOnlineDataSource: LoginOnlineDataSource
): LoginRepository {

    override suspend fun login(email: String, password: String): List<LoginData>? {
        return loginOnlineDataSource.login(email, password)
    }
}