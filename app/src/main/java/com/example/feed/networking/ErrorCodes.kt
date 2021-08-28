package com.example.feed.networking

import org.koin.dsl.module
import retrofit2.HttpException
import java.net.SocketTimeoutException

val responseHandlerModule = module {
    factory { ResponseHandler() }
}

open class ResponseHandler {

    suspend fun <T : Any> handle(block: suspend () -> StandardResponse<T>): Response<T> {
        return try {
            val response: StandardResponse<T> = block.invoke()
            when (response.status.error_code) {
                0 -> handleSuccess(response)
                else -> handleException(
                    FeedApiError(
                        response.status.error_code, response.status.message, response.result
                    )
                )
            }
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private fun <T : Any> handleSuccess(data: StandardResponse<T>): Response<T> {
        return Response.success(data.result)
    }

    private fun <T : Any> handleException(e: Exception): Response<T> {
        return when (e) {
            is HttpException -> Response.error(e.code(), e.message(), null)
            is SocketTimeoutException -> Response.error(-333, "Socket Timeout?!", null)
            is FeedApiError -> Response.error(e.errorCode, e.message, e.payload as T)
            else -> {
                e.printStackTrace()
                Response.error(-999, "Something Went Wrong" + e.localizedMessage, null)
            }
        }
    }

}