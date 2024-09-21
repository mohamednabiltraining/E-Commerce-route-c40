package com.route.domain.usecase.category

import com.route.domain.model.Category
import com.route.domain.model.ApiResult
import com.route.domain.repositories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {
    fun invoke(): Flow<ApiResult<List<Category>?>> {
        return categoriesRepository.getCategories()
    }
}