package com.example.feed.repository

import com.example.feed.modals.request.FeedRequest
import com.example.feed.modals.response.FeedResponse
import com.example.feed.networking.FeedApi
import com.example.feed.networking.Response
import com.example.feed.networking.ResponseHandler
import org.koin.dsl.module


val feedRemoteRepositoryModule = module {
    single { FeedRemoteRepository(get()) }
}
class FeedRemoteRepository(private val api : FeedApi) : FeedRepositoryContract {
    override suspend fun getFeedData(feedRequest: FeedRequest): Response<FeedResponse> = ResponseHandler().handle {  api.getFeedData(feedRequest) }
}