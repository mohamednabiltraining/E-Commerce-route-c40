package com.route.domain.repositories

import com.route.domain.model.ApiResult
import com.route.domain.model.LoginData
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email: String, password: String): Flow<ApiResult<LoginData?>>
}