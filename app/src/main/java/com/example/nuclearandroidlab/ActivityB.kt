package com.example.nuclearandroidlab

import android.app.ActivityManager.RunningTaskInfo
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nuclearandroidlab.ui.theme.NuclearAndroidLabTheme

class ActivityB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        //enableEdgeToEdge()
        val buttonOpenActivityC = findViewById<Button>(R.id.button_activity_b_open_activity_c)
        buttonOpenActivityC.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java)
                //.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(intent)
        }
    }
}