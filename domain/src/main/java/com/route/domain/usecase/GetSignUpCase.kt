package com.route.domain.usecase

import com.route.domain.repositories.SignUpRepository
import javax.inject.Inject

class GetSignUpCase @Inject constructor(
    private val signUpRepository: SignUpRepository
) {
    fun invoke(email: String, password: String, userName: String, mobileNum: String) =
        signUpRepository.signUp(email, password, userName, mobileNum)
}