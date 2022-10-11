package com.example.presentation

import androidx.lifecycle.ViewModel
import com.example.domain.VideosRepository

class VM(private val repository: VideosRepository) : ViewModel(){
    fun getNumber(a:Int):Int{
        return a*a
    }
}