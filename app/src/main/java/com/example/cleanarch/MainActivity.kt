package com.example.cleanarch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.data.Impl
import com.example.presentation.PresentationActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(this.packageName)
        startActivity(Intent(this, PresentationActivity::class.java))
    }
}
