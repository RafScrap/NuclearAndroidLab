package com.example.nuclearandroidlab

import android.app.ActivityManager
import android.app.ActivityManager.RunningTaskInfo
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity


class ActivityC : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        Log.d("ActivityC", taskId.toString())
        val buttonOpenActivityA = findViewById<Button>(R.id.button_activity_c_open_activity_a)
        buttonOpenActivityA.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent);
        }
    }
}