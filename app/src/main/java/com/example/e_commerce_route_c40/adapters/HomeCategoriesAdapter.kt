package com.example.e_commerce_route_c40.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerce_route_c40.databinding.ItemCategoryBinding
import com.route.domain.model.Category


class HomeCategoriesAdapter : RecyclerView.Adapter<HomeCategoriesAdapter.Holder>() {
    var categoryList: List<Category>? = null // implelent listOf category
    var onClick: ((Category,Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount() = categoryList?.size?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val category = categoryList!![position]
        holder.bind(category)
        onClick?.let {
            holder.itemView.setOnClickListener {
                onClick?.invoke(category,position)
            }

        }
    }


    fun changeData(categories: List<Category>?){
        categoryList = categories
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category ) { // implelent listOf category
            binding.apply {
                Glide.with(binding.root.context)
                    .load(category.image)
                    .into(ivCategories)
                tvCategories.text = category.name

            }

        }
    }
}