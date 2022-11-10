package com.example.worker.ui

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.work.*
import com.example.worker.R
import com.example.worker.worker.WorkerTask
import java.util.concurrent.TimeUnit

class WorkerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker)
        val title = findViewById<EditText>(R.id.title_edt)
        val body = findViewById<EditText>(R.id.body_edt)
        val time = findViewById<EditText>(R.id.time_edt)
        val button = findViewById<AppCompatButton>(R.id.btn_submit)
        button.setOnClickListener {
            createWorker(title.text.toString(), body.text.toString(), time.text.toString().toInt())
        }
    }

    private fun createWorker(title: String, body: String, time: Int) {
        val myData = Data.Builder()
            .putString("title", title)
            .putString("body", body)
            .build()
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresStorageNotLow(true)
            .setRequiresBatteryNotLow(true)
            .build()

        val request = OneTimeWorkRequest.Builder(WorkerTask::class.java)
            .setInitialDelay(time.toLong(), TimeUnit.SECONDS)
            .setConstraints(constraints)
            .setInputData(myData)
            .build()

        WorkManager
            .getInstance(this).enqueue(request)
    }
}