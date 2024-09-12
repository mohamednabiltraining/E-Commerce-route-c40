package com.route.domain.usecase

import com.route.domain.model.LoginData
import com.route.domain.repositories.LoginRepository
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend fun invoke(email: String, password: String): List<LoginData>? {
        return loginRepository.login(email, password)
    }
}