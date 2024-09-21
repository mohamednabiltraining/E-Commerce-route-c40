package com.route.domain.usecase.category

import com.route.domain.model.ApiResult
import com.route.domain.model.SubCategory
import com.route.domain.repositories.CategoriesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSubCategoriesUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {
    fun invoke(categoryId:String): Flow<ApiResult<List<SubCategory>?>> {
        return categoriesRepository.getSubCategories(categoryId)
    }
}