package com.example.feed.modals.response

import android.os.Parcelable
import com.example.feed.modals.response.Data
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FeedResponse(
    val data : List<Data>
) :Parcelable
