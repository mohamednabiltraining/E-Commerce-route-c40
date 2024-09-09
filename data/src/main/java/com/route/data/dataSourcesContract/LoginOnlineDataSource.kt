package com.route.data.dataSourcesContract

import com.route.data.api.model.response.User

interface LoginOnlineDataSource {
    suspend fun login(email: String, password: String): User?
}