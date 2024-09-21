package com.route.domain.usecase.auth

import com.route.domain.model.ApiResult
import com.route.domain.model.AuthData
import com.route.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(
    private val loginRepository: AuthRepository
) {
    fun invoke(email: String? = null, password: String?=null): Flow<ApiResult<AuthData?>> {
        return loginRepository.login(email, password)
    }
}