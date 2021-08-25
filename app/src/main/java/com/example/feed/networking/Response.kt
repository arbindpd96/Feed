package com.example.feed.networking

import androidx.annotation.Keep

@Keep
data class Response<out T>(val status: Status, val payload: T?, val message: String?, val code: Int?) {
    companion object {
        fun <T> success(data: T): Response<T> {
            return Response(Status.SUCCESS, data, null, null)
        }

        fun <T> error(code: Int, msg: String, payload: T?): Response<T> {
            return Response(Status.ERROR, payload, msg, code)
        }

        fun <T> loading(data: T?): Response<T> {
            return Response(Status.LOADING, data, null, null)
        }
    }
}