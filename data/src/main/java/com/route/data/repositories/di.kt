package com.route.data.repositories

import com.route.domain.repositories.CategoriesRepository
import com.route.domain.repositories.ProductsRepository

import com.route.domain.repositories.AuthRepository
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
    abstract fun bindProductsRepo(
        productsRepositoryImpl: ProductsRepositoryImpl
    ): ProductsRepository

    @Binds
    abstract fun bindAuthRepo(
        abstractRepo: AuthRepoImpl
    ):AuthRepository



}