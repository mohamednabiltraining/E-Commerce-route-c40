package com.example.e_commerce_route_c40.util

import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.e_commerce_route_c40.R
import com.google.android.material.bottomappbar.BottomAppBar

fun Fragment.showToast(massage: Any?) {
    Toast.makeText(requireContext(), "$massage", Toast.LENGTH_LONG).show()
}
fun Fragment.hideBottomAppBarViews() {
    requireActivity().findViewById<BottomAppBar>(R.id.bottom_nav_container).visibility = View.GONE

    // set marginBottom = 0
    val constraintLayout = requireActivity().findViewById<ConstraintLayout>(R.id.fragmentContainerView)
    val params = constraintLayout.layoutParams as ViewGroup.MarginLayoutParams
    params.bottomMargin = 0
    constraintLayout.layoutParams = params
}

fun Fragment.showBottomAppBarViews() {
    requireActivity().findViewById<BottomAppBar>(R.id.bottom_nav_container).visibility = View.VISIBLE

    // set marginBottom = actionBarSize
    val typedValue = TypedValue()
    val theme = requireActivity().theme
    theme.resolveAttribute(android.R.attr.actionBarSize, typedValue, true)
    val actionBarSize =
        TypedValue.complexToDimensionPixelSize(typedValue.data, resources.displayMetrics)

    val constraintLayout = requireActivity().findViewById<ConstraintLayout>(R.id.fragmentContainerView)
    val params = constraintLayout.layoutParams as ViewGroup.MarginLayoutParams
    params.bottomMargin = actionBarSize
    constraintLayout.layoutParams = params
}