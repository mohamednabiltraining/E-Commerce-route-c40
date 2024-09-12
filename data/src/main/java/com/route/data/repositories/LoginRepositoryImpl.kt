package com.route.data.repositories


import com.route.data.dataSourcesContract.LoginOnlineDataSource
import com.route.domain.model.LoginData
import com.route.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val onlineDataSource: LoginOnlineDataSource
): LoginRepository {
    override suspend fun login(email: String, password: String): LoginData {
        val user = onlineDataSource.login(email, password)
        return LoginData(
            user?.name,
            user?.email,
            user?.role
        )
    }
}