package com.alican.mvvm_starter.base

import android.content.Context
import android.util.Log
import com.alican.mvvm_starter.data.repository.Result
import com.alican.mvvm_starter.util.utils.toast
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


open class BaseRepository @Inject constructor(@ApplicationContext private val context: Context) {

    var alreadySent: Boolean = false


    suspend fun <T : Any> request(call: suspend () -> Response<T>): T? {

        val result: Result<T> = apiResult(call)
        var data: T? = null

        when (result) {
            is Result.Success -> data = result.data
            is Result.DataError -> {
                Log.d("data error", "${result.errorCode}")
            }
            is Result.NetworkError -> {
                Log.d("network error", "${result.exception}")
            }
        }


        return data

    }

    private suspend fun <T : Any> apiResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                return Result.Success(response.body()!!)
            } else {
                if (response.code() != 404) {
                    try {
                        val jObjError = JSONObject(response.errorBody()!!.string())
                        val errorMessage = jObjError.getJSONArray("Errors").get(0).toString()
                        if (!errorMessage.equals("Bad Request")) {
                            context.toast(errorMessage)
                        }
                    } catch (e: java.lang.Exception) {
                        context.toast(response.message())
                    }
                }
                return Result.NetworkError(Exception())
            }
        } catch (e: Exception) {
            return Result.NetworkError(Exception())
        }
    }
}