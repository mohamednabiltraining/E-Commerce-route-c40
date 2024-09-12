package com.route.domain.usecase

import com.route.domain.repositories.LoginRepository
import javax.inject.Inject

class GetLoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){
    suspend fun invoke(email:String,password:String) = loginRepository.login(email,password)
}