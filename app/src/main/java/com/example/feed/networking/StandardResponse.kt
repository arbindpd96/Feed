package com.example.feed.networking

import androidx.annotation.Keep

@Keep
data class StandardResponse<T>(
    val status: StatusResp, val result: T
)

@Keep
data class StatusResp(
    val error_code: Int, val message: String
)