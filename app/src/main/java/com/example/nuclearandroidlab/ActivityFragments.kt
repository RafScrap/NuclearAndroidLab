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
import kotlin.random.Random

class ActivityFragments : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        if (this.getResources().configuration.orientation == ORIENTATION_LANDSCAPE) {
            this.supportFragmentManager.commit {
                val newArgs = bundleOf("fragmentBBIsOpen" to true, "color" to Random.nextInt())
                val fBA = FragmentBA();
                fBA.arguments = newArgs;
                add(R.id.fragment_container_view_ba, fBA)
                add(R.id.fragment_container_view_bb, FragmentBB())
            }
        }

        if (this.getResources().configuration.orientation == ORIENTATION_PORTRAIT) {
            this.supportFragmentManager.commit {
                val newArgs = bundleOf("fragmentBBIsOpen" to false)
                val fBA = FragmentBA();
                fBA.arguments = newArgs;
                add(R.id.fragment_container_view_ba, fBA)
            }
        }
    }
}