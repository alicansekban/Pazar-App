package com.alican.mvvm_starter.data.repository

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class NetworkError(val exception: Exception) : Result<Nothing>()
    data class DataError(val errorCode: Int) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is NetworkError -> "Error[exception=$exception]"
            is DataError -> "Error[errorCode=$errorCode]"
        }
    }
}