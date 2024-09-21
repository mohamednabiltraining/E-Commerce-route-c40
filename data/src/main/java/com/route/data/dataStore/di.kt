package com.route.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

// At the top level of your kotlin file:
val Context.userPreferences: DataStore<Preferences> by preferencesDataStore(name = "User-prefences")

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule{

    @Provides
    @Singleton
    @UserDataStore
    fun provideUserDataStore(@ApplicationContext context:Context):DataStore<Preferences> {
        return context.userPreferences
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserDataStore