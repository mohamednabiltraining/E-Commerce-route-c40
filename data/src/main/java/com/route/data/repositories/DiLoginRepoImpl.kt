package com.route.data.repositories

import com.route.domain.repositories.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DiLoginRepoImpl {

    @Binds
    abstract fun bindLoginRepo(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository

}