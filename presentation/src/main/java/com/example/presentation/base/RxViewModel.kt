package com.example.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class RxViewModel : ViewModel() {


    protected val error = MutableLiveData<String>()
    val errorException: LiveData<String>
        get() = error

    val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

}
