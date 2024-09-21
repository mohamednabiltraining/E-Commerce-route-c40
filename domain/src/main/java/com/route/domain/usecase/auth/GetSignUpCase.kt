package com.route.domain.usecase.auth

import com.route.domain.repositories.AuthRepository
import javax.inject.Inject

class GetSignUpCase @Inject constructor(
    private val signUpRepository: AuthRepository
) {
    fun invoke(email: String, password: String, userName: String, mobileNum: String) =
        signUpRepository.signUp(email, password, userName, mobileNum)
}