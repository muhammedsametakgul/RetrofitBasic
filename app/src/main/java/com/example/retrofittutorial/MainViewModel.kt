package com.example.retrofittutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private val _post = MutableLiveData<MyPost>()
    val post: LiveData<MyPost>
        get() = _post

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _hasError = MutableLiveData<Boolean>()
    val hasError: LiveData<Boolean>
        get() = _hasError

    init {
        fetchPost()
    }

    fun fetchPost() {
        viewModelScope.launch {
            delay(2000)
           val post:MyPost =RetrofitInstance.api.fetchPost()
            _post.value=post
            _isLoading.value=false


        }
    }
}