package com.example.e_commerce_route_c40.util

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.e_commerce_route_c40.ui.activities.MainActivity

fun Fragment.showToast(massage: Any?) {
    Toast.makeText(requireContext(), "$massage", Toast.LENGTH_LONG).show()
}
fun MainActivity.makeNavyBottomVisible(visibility: Boolean) {
    binding.bottomNavigation.visibility = if (visibility) View.VISIBLE else View.GONE
}