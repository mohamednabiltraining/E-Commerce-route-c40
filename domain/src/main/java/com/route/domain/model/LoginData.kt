package com.route.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginData(
    val email: String? = null,
    val password: String? = null,
    val token: String? = null,
): Parcelable