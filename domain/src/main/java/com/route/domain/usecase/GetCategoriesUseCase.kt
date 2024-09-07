package com.route.domain.usecase

import com.route.domain.model.Category
import com.route.domain.repositories.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {
    suspend fun invoke():List<Category>? {
        return categoriesRepository.getCategories()
    }
}