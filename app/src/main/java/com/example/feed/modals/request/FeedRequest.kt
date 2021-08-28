package com.example.feed.modals.request

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FeedRequest(
    var store_id : String? = null,
    var u_id :String? = null,
    var access_type : String? = null,
    var source : String? = null
) : Parcelable

//{"store_id":"3","u_id":"","access_type":"1","source":"mob"}
