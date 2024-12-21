package com.example.nuclearandroidlab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)
        val summonsView = findViewById<ImageView>(R.id.go_to_summons)
        summonsView.setOnClickListener {
            val intentToSummons = Intent(this, SummonsActivity::class.java)
            startActivity(intentToSummons)
        }
        summonsView.isClickable = true;

        val profileView = findViewById<CardView>(R.id.profile)
        profileView.setOnClickListener {
            val intentToProfile = Intent(this, ProfileActivity::class.java)
            Log.d("profile", "1")
            startActivity(intentToProfile)
        }
        profileView.isClickable = true;
    }
}
