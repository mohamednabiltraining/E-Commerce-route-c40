package com.route.data.api.model.response

import com.google.gson.annotations.SerializedName
import com.route.domain.model.Category
import com.route.domain.model.SubCategory

data class CategoryDto(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
){

	// convert
	fun toCategory():Category{
		return Category(
			id = id,
			image = image,
			name = name,
			slug = slug
		)
	}
	fun toSubCategory():SubCategory{
		return SubCategory(
			id = id,
			image = image,
			name = name,
			slug = slug
		)
	}
}