package com.example.feed.repository

import com.example.feed.modals.request.FeedRequest
import com.example.feed.modals.response.FeedResponse
import com.example.feed.networking.Response
import org.koin.dsl.module


val feedRepoModule = module {
    single { Feedrepository(get()) }
}
class Feedrepository(private val feedRemoteRepo  : FeedRemoteRepository) : FeedRepositoryContract {
    override suspend fun getFeedData(feedRequest: FeedRequest): Response<FeedResponse> {
        return feedRemoteRepo.getFeedData(feedRequest)
    }
}