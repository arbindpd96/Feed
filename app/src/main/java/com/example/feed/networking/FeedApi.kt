package com.example.feed.networking


import com.example.feed.modals.request.FeedRequest
import com.example.feed.modals.response.FeedResponse
import com.example.feed.networking.StandardResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedApi {
    @GET("/PinkDelivery/dev/api/product/get")
    suspend fun getFeedData(feedRequest : FeedRequest): StandardResponse<FeedResponse>
}
