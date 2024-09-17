package com.route.data.repositories

import com.route.data.dataSourcesContract.AuthOnlineDataSource
import com.route.domain.model.ApiResult
import com.route.domain.model.LoginData
import com.route.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(
    private val loginOnlineDataSource: AuthOnlineDataSource
): AuthRepository {

    override fun login(email: String, password: String): Flow<ApiResult<LoginData?>> {
        return loginOnlineDataSource.login(email, password)
    }
}