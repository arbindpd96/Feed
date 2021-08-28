package com.example.feed.repository

import com.example.feed.modals.request.FeedRequest
import com.example.feed.modals.response.FeedResponse
import com.example.feed.networking.Response

interface  FeedRepositoryContract {
    suspend fun getFeedData(feedRequest: FeedRequest) : Response<FeedResponse>
}