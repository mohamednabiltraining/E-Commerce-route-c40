package com.route.data.dataSourcesContract

import com.route.domain.model.LoginData

interface LoginOnlineDataSource {
    suspend fun login(email: String, password: String): List<LoginData>?
}