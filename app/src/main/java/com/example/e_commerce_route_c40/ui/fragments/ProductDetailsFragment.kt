package com.example.e_commerce_route_c40.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.e_commerce_route_c40.R

class ProductDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_product_details, container, false)

        val tvDescription = view.findViewById<TextView>(R.id.Tv_Description_Text)
        val tvReadMore = view.findViewById<TextView>(R.id.Tv_Read_More)

        var isExpanded = false

        tvReadMore.setOnClickListener {
            if (isExpanded) {
                tvDescription.maxLines = 2
                tvReadMore.text = "Read More"
            } else {
                tvDescription.maxLines = Integer.MAX_VALUE
                tvReadMore.text = "Read Less"
            }
            isExpanded = !isExpanded
        }

        return view
    }
}
