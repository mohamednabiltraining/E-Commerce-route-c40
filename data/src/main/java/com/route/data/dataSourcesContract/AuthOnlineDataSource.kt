package com.route.data.dataSourcesContract

import com.route.domain.model.ApiResult
import com.route.domain.model.LoginData
import kotlinx.coroutines.flow.Flow

interface AuthOnlineDataSource {
    fun login(email: String, password: String): Flow<ApiResult<LoginData?>>
}