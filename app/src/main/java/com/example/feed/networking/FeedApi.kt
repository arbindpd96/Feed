package com.example.feed.networking


import com.example.feed.modals.request.FeedRequest
import com.example.feed.modals.response.FeedResponse
import com.example.feed.networking.StandardResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FeedApi {
    @POST("/PinkDelivery/dev/api/product/get")
    suspend fun getFeedData(@Body feedRequest : FeedRequest): StandardResponse<FeedResponse>
}
