package com.example.feed.modals.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Items (
	val product_id : Int,
	val product_suk_id : String,
	val product_name : String,
	val category_id : Int,
	val description : String,
	val product_image : String,
	val price : Double,
	val vendor_id : Int,
	val status : Int,
	val created_at : String,
	val updated_at : String,
	val category_name : String,
	val vendor_name : String
) : Parcelable