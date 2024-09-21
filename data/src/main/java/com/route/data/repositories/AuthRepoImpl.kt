package com.route.data.repositories

import com.route.data.dataSourcesContract.AuthOfflineDataSource
import com.route.data.dataSourcesContract.AuthOnlineDataSource
import com.route.domain.cusomException.ServerError
import com.route.domain.model.ApiResult
import com.route.domain.model.AuthData
import com.route.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(
    private val authOnlineDataSource: AuthOnlineDataSource,
    private val authOfflineDataSource: AuthOfflineDataSource
): AuthRepository {

    override fun login(email: String?, password: String?): Flow<ApiResult<AuthData?>> =
        flow {
            if(email == null || password==null){
                val cachedUser =  authOfflineDataSource.retrieveUser().first()
                if(cachedUser!=null) emit(ApiResult.Success(cachedUser))
                else {
                    emit(ApiResult.Failure(ServerError()))
                }
                return@flow
            }

            // from api
            authOnlineDataSource.login(email, password).collect{result->
                if(result is ApiResult.Success){
                    result.data?.let { authOfflineDataSource.saveUser(it) }
                }
                emit(result)
            }



        }

    override fun signUp(
        email: String,
        password: String,
        userName: String,
        mobileNum: String
    ): Flow<ApiResult<AuthData?>> = flow {
        authOnlineDataSource.signUp(email, password, userName, mobileNum).collect{result->
            if(result is ApiResult.Success){
                result.data?.let { authOfflineDataSource.saveUser(it) }
            }
            emit(result)
        }

    }
}