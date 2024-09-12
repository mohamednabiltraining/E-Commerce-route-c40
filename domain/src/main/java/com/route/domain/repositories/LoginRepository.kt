package com.route.domain.repositories

import com.route.domain.model.LoginData

interface LoginRepository {
    suspend fun login(email: String, password: String): LoginData
}
