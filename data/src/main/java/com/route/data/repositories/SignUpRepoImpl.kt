package com.route.data.repositories

import com.route.data.dataSourcesContract.SignUpOnlineDataSource
import com.route.domain.model.ApiResult
import com.route.domain.model.SignUpData
import com.route.domain.repositories.SignUpRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpRepoImpl @Inject constructor(
    private val signUpOnlineDataSource: SignUpOnlineDataSource
): SignUpRepository {

    override fun signUp(
        email: String,
        password: String,
        userName: String,
        mobileNum: String
    ): Flow<ApiResult<SignUpData?>> {
        return signUpOnlineDataSource.signUp(email, password, userName, mobileNum)
    }
}