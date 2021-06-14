package com.wotr.data.remote

sealed class ApiResult<out T> {

    data class Success<out T>(val data : T) : ApiResult<T>()

    object NoResult : ApiResult<Nothing>()
    object ServerError : ApiResult<Nothing>()

}