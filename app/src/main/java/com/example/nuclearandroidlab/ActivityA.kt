package com.example.nuclearandroidlab

import android.app.ActivityManager.RunningTaskInfo
import android.content.Intent
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val buttonOpenActivityB = findViewById<Button>(R.id.button_activity_a_open_activity_b)
        buttonOpenActivityB.setOnClickListener {
            val intentB = Intent(this, ActivityB::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intentB)
        }
        Log.d("ActivityA", taskId.toString())
        val buttonOpenFragmentB = findViewById<Button>(R.id.button_activity_a_open_fragment_b)
        buttonOpenFragmentB.setOnClickListener {
            val intentFragments = Intent(this, ActivityFragments::class.java)
            startActivity(intentFragments)
        }
    }
}