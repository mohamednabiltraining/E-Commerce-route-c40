package com.route.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthData(
    val email: String? = null,
    val token: String? = null,
    val name:String? = null
): Parcelable