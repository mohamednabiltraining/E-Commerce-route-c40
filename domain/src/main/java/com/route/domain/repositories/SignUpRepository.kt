package com.route.domain.repositories

import com.route.domain.model.ApiResult
import com.route.domain.model.SignUpData
import kotlinx.coroutines.flow.Flow

interface SignUpRepository {
    fun signUp(email: String, password: String, userName: String, mobileNum: String): Flow<ApiResult<SignUpData?>>
}