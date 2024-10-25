package com.example.nuclearandroidlab

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nuclearandroidlab.ui.theme.NuclearAndroidLabTheme

class ActivityA : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        //enableEdgeToEdge()
        val buttonOpenActivityB = findViewById<Button>(R.id.button_activity_a_open_activity_b)
        buttonOpenActivityB.setOnClickListener {
        }
        val buttonOpenFragmentB = findViewById<Button>(R.id.button_activity_a_open_fragment_b)
        buttonOpenFragmentB.setOnClickListener {
        }
    }
}