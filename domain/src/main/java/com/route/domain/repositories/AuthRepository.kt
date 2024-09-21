package com.route.domain.repositories

import com.route.domain.model.ApiResult
import com.route.domain.model.AuthData
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login(email: String? = null, password: String?=null): Flow<ApiResult<AuthData?>>
    fun signUp(email: String, password: String, userName: String, mobileNum: String): Flow<ApiResult<AuthData?>>
}