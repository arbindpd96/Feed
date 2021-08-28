package com.example.feed.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.feed.networking.Response
import com.example.feed.repository.Feedrepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application : Application , private val feedrepository: Feedrepository) : AndroidViewModel(application) {

    private var feedResponse = MutableLiveData<Response<String>>()

    fun getFeedData(){
        viewModelScope.launch {
           feedResponse.postValue( feedrepository.getFeedData() )
        }
    }
}