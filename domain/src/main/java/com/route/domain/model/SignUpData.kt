package com.route.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SignUpData(
    val email: String? = null,
    val name:String? = null,
    val phone:String? = null,
    val password:String? = null
): Parcelable