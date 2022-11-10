package com.example.worker.worker

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.worker.R

class WorkerTask(ctx: Context, val params: WorkerParameters) : Worker(ctx, params) {
    private val channelId = "12000"

    override fun doWork(): Result {
        return try {
            sendNotification(
                params.inputData.getString("title"), params.inputData.getString("body")
            )
            Result.success()
        } catch (throwable: Throwable) {
            Result.failure()
        }
    }


    private fun sendNotification(tittle: String?, messageBody: String?) {
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(R.drawable.ic_launcher_background).setContentTitle(tittle)
                .setContentText(messageBody).setAutoCancel(true).setSound(defaultSoundUri)
                .setDefaults(Notification.DEFAULT_ALL)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            notificationBuilder.priority = NotificationManager.IMPORTANCE_HIGH
        }
        val notificationManager = NotificationManagerCompat.from(applicationContext)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId, "Channel human readable title", NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }

    companion object {
        const val KEY_LAT = "KEY_LAT"
        const val KEY_LONG = "KEY_LONG"
        const val KEY_LOCATION = "KEY_LOCATION"
    }
}
