package com.route.data.repositories

import com.route.domain.repositories.CategoriesRepository
import com.route.domain.repositories.AuthRepository
import com.route.domain.repositories.SignUpRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesBinder{

    @Binds
    abstract fun bindCategoriesRepo(
        categoriesRepoImpl: CategoriesRepoImpl
    ):CategoriesRepository

    @Binds
    abstract fun bindAuthRepo(
        abstractRepo: AuthRepoImpl
    ):AuthRepository

    @Binds
    abstract fun bindSignUpRepo(
        signUpRepoImpl: SignUpRepoImpl
    ): SignUpRepository

}