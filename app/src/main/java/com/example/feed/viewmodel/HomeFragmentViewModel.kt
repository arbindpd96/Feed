package com.example.feed.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feed.modals.request.FeedRequest
import com.example.feed.modals.response.FeedResponse
import com.example.feed.networking.Response
import com.example.feed.repository.Feedrepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application : Application , private val feedrepository: Feedrepository) : AndroidViewModel(application) {

     var feedResponse = MutableLiveData<Response<FeedResponse>>()

    fun getFeedData(feedRequest: FeedRequest){
        viewModelScope.launch {
           feedResponse.postValue( feedrepository.getFeedData(feedRequest) )
        }
    }
}