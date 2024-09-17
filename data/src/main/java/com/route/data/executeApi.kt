package com.route.data

import com.google.gson.Gson
import com.route.data.api.model.ServerErrorResponse
import com.route.domain.cusomException.ConnectionError
import com.route.domain.cusomException.ServerError
import com.route.domain.model.ApiResult
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeoutException

fun <T> executeApi(api: suspend () -> T) =
    flow {
        try {
            emit(ApiResult.Loading(isLoading = true))
            val response = api.invoke()
            emit(ApiResult.Loading(isLoading = false))
            emit(ApiResult.Success(data = response))
        } catch (ex: Exception) {
            when (ex) {
                is HttpException -> {
                    val serverResponse = ex.response()?.errorBody()?.string()
                    val error = Gson().fromJson(serverResponse, ServerErrorResponse::class.java)
                    emit(
                        ApiResult.Failure(
                            ServerError(
                                serverMessage = error.message,
                                statusMsg = error.statusMsg,
                            ),
                        ),
                    )
                }

                is IOException,
                is TimeoutException,
                -> {
                    emit(ApiResult.Failure(ConnectionError()))
                }
                else -> emit(ApiResult.Failure(ex))
            }
        }
    }
