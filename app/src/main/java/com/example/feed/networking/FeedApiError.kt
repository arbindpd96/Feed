package com.example.feed.networking

import java.lang.Exception

class FeedApiError(val errorCode: Int, override val message: String, val payload: Any?) : Exception(message)