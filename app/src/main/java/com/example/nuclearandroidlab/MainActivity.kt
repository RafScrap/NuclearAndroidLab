package com.example.nuclearandroidlab
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.activity.ComponentActivity

import androidx.core.app.NotificationCompat
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit


class EverydayWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.d("show", "show1")
        try {
            notifactionShow("ДЗ","Необходимо выполнить ДЗ");
        } catch (ex: Exception) {
            return Result.failure(); //или Result.retry()
        }
        return Result.success();
    }

    fun notifactionShow(title: String?, desc: String?) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "channelId"
            val channel = NotificationChannel(
                channelId,
                channelId,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
            val builder: NotificationCompat.Builder =
                NotificationCompat.Builder(applicationContext, channelId)
                    .setContentTitle(title)
                    .setContentText(desc)
                    .setSmallIcon(R.mipmap.ic_launcher)

            notificationManager.notify(1, builder.build())
            Log.d("hw3", "addNotification")
        }
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.layout_main_activity)

        val channelId = getString(R.string.channel_id)
        val workRequest: PeriodicWorkRequest =
            PeriodicWorkRequestBuilder<EverydayWorker>(
            1, TimeUnit.DAYS,
            5, TimeUnit.MINUTES
        ).build()
        WorkManager.getInstance(application.applicationContext).enqueueUniquePeriodicWork(
            channelId, ExistingPeriodicWorkPolicy.KEEP, workRequest
        )
        Log.d("hw3", "onCreate")
    }
}
