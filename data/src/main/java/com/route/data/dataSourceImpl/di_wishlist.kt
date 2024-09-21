package com.route.data.dataSourceImpl


import com.route.data.dataSourcesContract.WishlistOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceBinderWishlist{

    @Binds
    abstract fun bindOnlineDataSource(
        wishlistOnlineDataSourceImpl: WishlistOnlineDataSourceImp
    ): WishlistOnlineDataSource
}