package com.route.data.dataSourceImpl

import com.route.data.dataSourcesContract.LoginOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DiLoginOnline {

    @Binds
    abstract fun bindOnlineDataSource(
        loginOnlineDataSourceImpl: LoginOnlineDataSourceImpl
        ): LoginOnlineDataSource
}