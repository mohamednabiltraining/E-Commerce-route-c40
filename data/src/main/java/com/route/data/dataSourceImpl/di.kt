package com.route.data.dataSourceImpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.google.gson.Gson
import com.route.data.dataStore.UserDataStore
import com.route.data.dataSourcesContract.AuthOfflineDataSource
import com.route.data.dataSourcesContract.AuthOnlineDataSource
import com.route.data.dataSourcesContract.CategoriesOnlineDataSource
import dagger.Binds
import com.route.data.dataSourcesContract.ProductsOnlineDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceBinder{

    @Binds
    abstract fun bindOnlineDataSource(
        categoriesOnlineDataSourceImpl: CategoriesOnlineDataSourceImpl
    ): CategoriesOnlineDataSource

    @Binds
    abstract fun bindAuthOnlineDataSource(
        datasourceImpl: AuthOnlineDataSourceImpl
    ): AuthOnlineDataSource
}

    @Binds
    abstract fun bindProductsDataSource(
        datasourceImpl: ProductsOnlineDataSourceImpl
    ): ProductsOnlineDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object OfflineDataSourceModule{
    @Provides
    @Singleton
    fun provideAuthOfflineDataSource(
        @UserDataStore userDataStore: DataStore<Preferences>,
        gson: Gson

    ): AuthOfflineDataSource{
        return AuthOfflineDataSourceImpl(
            userDataStore,
            gson
        )
    }
}
