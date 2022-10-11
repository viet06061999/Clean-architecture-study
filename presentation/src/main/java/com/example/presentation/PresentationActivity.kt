package com.example.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel

class PresentationActivity : AppCompatActivity() {
    val vm: VM by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presentation)
        println(this.packageName)
        vm.getNumber(2)
    }
}
