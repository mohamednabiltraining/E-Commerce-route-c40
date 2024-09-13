package com.example.e_commerce_route_c40.ui.fragments.category

import android.app.AlertDialog
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
class Di {

    @Provides
    @FragmentScoped
    fun provideLoadingDialog(@ActivityContext context: Context):AlertDialog{
        val builder = AlertDialog.Builder(context)
        val progressDialog = builder.create()
        return progressDialog
    }
    @Provides
    @FragmentScoped
    fun provideCategoriesAdaptor(
        alertDialog: AlertDialog
    ):CategoriesAdapter{
        return CategoriesAdapter(alertDialog)
    }
    @Provides
    @FragmentScoped
    fun provideSubCategoriesAdaptor(
        alertDialog: AlertDialog
    ):SubCategoriesAdapter{
        return SubCategoriesAdapter(alertDialog)
    }
}