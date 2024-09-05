//package com.example.e_commerce_route_c40.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.e_commerce_route_c40.databinding.ItemCategoryBinding
//
//
//class AdapterCategories : RecyclerView.Adapter<AdapterCategories.Holder>() {
//    var categoryList: List<modelOfCategories>? = null // implelent listOf category
//    private lateinit var onClick: (Int) -> Unit?
//    fun setOnClick(onClick: (Int) -> Unit) {
//        this.onClick = onClick}
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
//        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return Holder(binding)
//    }
//
//    override fun getItemCount() = categoryList?.size?: 0
//
//    override fun onBindViewHolder(holder: Holder, position: Int) {
//        val data = categoryList!![position]
//        holder.bind(data)
//    }
//
//    inner class Holder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            binding.root.setOnClickListener {
//                onClick.invoke(categoryList!![layoutPosition].id)
//            }
//        }
//
//        fun bind(categoryList: modelOfCategories ) { // implelent listOf category
//            binding.apply {
//                Glide.with(binding.root.context)
//                    .load(categoryList.strCategoryThumb)
//                    .into(ivCategories)
//                tvCategories.text = name
//
//            }
//
//        }
//    }
//}