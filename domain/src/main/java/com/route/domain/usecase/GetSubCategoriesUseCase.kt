package com.route.domain.usecase

import com.route.domain.model.SubCategory
import com.route.domain.repositories.CategoriesRepository
import javax.inject.Inject

class GetSubCategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {
    suspend fun invoke(categoryId:String):List<SubCategory>? {
        return categoriesRepository.getSubCategories(categoryId)
    }
}