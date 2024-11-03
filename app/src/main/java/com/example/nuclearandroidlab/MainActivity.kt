package com.example.nuclearandroidlab
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*import android.app.NotificationChannel
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
import java.util.concurrent.TimeUnit*/


/*class EverydayWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        Log.d("show", "show2")
        try {
            notifactionShow("title","desc");
        } catch (ex: Exception) {
            return Result.failure(); //или Result.retry()
        }
        return Result.success();
    }

    fun notifactionShow(title: String?, desc: String?) {
        Log.d("show", "show1")
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "@string/channel_id",
                "@string/channel_id",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
            val builder: NotificationCompat.Builder =
                NotificationCompat.Builder(applicationContext, "@string/channel_id")
                    .setContentTitle(title)
                    .setContentText(desc)
                    .setSmallIcon(R.mipmap.ic_launcher)

            notificationManager.notify(1, builder.build())
        }
    }
}*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.layout_main_activity)
        /*val workRequest : PeriodicWorkRequest =
            PeriodicWorkRequestBuilder<EverydayWorker>(
                3, TimeUnit.MINUTES,
                1, TimeUnit.MINUTES
            ).build()
        Log.d("show", "show0")
        WorkManager.getInstance(application.applicationContext).enqueueUniquePeriodicWork("PWR",
            ExistingPeriodicWorkPolicy.KEEP, workRequest)*/
    }
}
