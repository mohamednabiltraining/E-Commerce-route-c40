package com.route.data.dataSourcesContract

import com.route.domain.model.ApiResult
import com.route.domain.model.AuthData
import kotlinx.coroutines.flow.Flow

interface AuthOnlineDataSource {
    fun login(email: String, password: String): Flow<ApiResult<AuthData?>>
    fun signUp(email: String, password: String, userName: String, mobileNum: String): Flow<ApiResult<AuthData?>>

}