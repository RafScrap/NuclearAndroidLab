package com.example.nuclearandroidlab

import android.app.ActivityManager.RunningTaskInfo
import android.content.Intent
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import com.example.nuclearandroidlab.ui.theme.NuclearAndroidLabTheme

class ActivityA : AppCompatActivity() {

    private var FragmentsisOpen : Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val buttonOpenActivityB = findViewById<Button>(R.id.button_activity_a_open_activity_b)
        buttonOpenActivityB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }
        val buttonOpenFragmentB = findViewById<Button>(R.id.button_activity_a_open_fragment_b)
        buttonOpenFragmentB.setOnClickListener {
            if (!FragmentsisOpen) {
                if (this.getResources().configuration.orientation == ORIENTATION_LANDSCAPE) {
                    this.supportFragmentManager.commit {
                        val newArgs = bundleOf("FragmentBBIsOpen" to true, "color" to Color.parseColor("#f44336"))
                        val fBA = FragmentBA();
                        fBA.arguments = newArgs;
                        add(R.id.fragment_container_view_ba, fBA)
                        add(R.id.fragment_container_view_bb, FragmentBB())
                    }
                }

                if (this.getResources().configuration.orientation == ORIENTATION_PORTRAIT) {
                    this.supportFragmentManager.commit {
                        val newArgs = bundleOf("FragmentBBIsOpen" to false)
                        val fBA = FragmentBA();
                        fBA.arguments = newArgs;
                        add(R.id.fragment_container_view_ba, fBA)
                    }
                }
                FragmentsisOpen = true;
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        outState.putBoolean("FragmentsisOpen", FragmentsisOpen)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // Here You have to restore count value
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            FragmentsisOpen = savedInstanceState.getBoolean("FragmentsisOpen")
        }
    }
}