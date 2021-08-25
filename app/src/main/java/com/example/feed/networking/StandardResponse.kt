package com.example.feed.networking

import androidx.annotation.Keep

@Keep
data class StandardResponse<T>(
        val statusCode: Int,
        val message: String,
        val payload: T
)