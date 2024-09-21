package com.route.data.dataSourcesContract

import com.route.domain.model.AuthData
import kotlinx.coroutines.flow.Flow

interface AuthOfflineDataSource {
    fun retrieveUser(): Flow<AuthData?>
    suspend fun saveUser(response:AuthData)
}