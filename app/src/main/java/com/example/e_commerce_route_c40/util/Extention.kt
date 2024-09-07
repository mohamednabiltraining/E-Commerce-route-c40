package com.example.e_commerce_route_c40.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(massage: Any?) {
    Toast.makeText(requireContext(), "$massage", Toast.LENGTH_LONG).show()
}