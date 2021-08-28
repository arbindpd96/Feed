package com.example.feed.modals.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Data (

	val cat_id : Int,
	val cat_name : String,
	val items : List<Items>
) : Parcelable