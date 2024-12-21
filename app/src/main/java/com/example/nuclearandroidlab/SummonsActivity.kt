package com.example.nuclearandroidlab

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap


class SummonsActivity : AppCompatActivity() {
    private lateinit var cards : Cards;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.summons_activity)
        val grid = findViewById<GridLayout>(R.id.gridlayout_summons);
        val btnMakeSummons = findViewById<Button>(R.id.make_summons);
        val imageViews : List<ImageView> = listOf(
            findViewById<ImageView>(R.id.summon_image_0),
            findViewById<ImageView>(R.id.summon_image_1),
            findViewById<ImageView>(R.id.summon_image_2))
        cards = Cards(imageViews)
        if (savedInstanceState != null) {
            val bitmap0 = savedInstanceState.getParcelable<Bitmap>("image0")
            cards.setImage(0, bitmap0!!);
            val bitmap1 = savedInstanceState.getParcelable<Bitmap>("image1")
            cards.setImage(1, bitmap1!!);
            val bitmap2 = savedInstanceState.getParcelable<Bitmap>("image2")
            cards.setImage(2, bitmap2!!);
        }

        btnMakeSummons.setOnClickListener {
            cards.changeImage()
        }
        val btnToMain = findViewById<Button>(R.id.come_back_summons)
        btnToMain.setOnClickListener {
            val intentToMainActivity = Intent(this, MainActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intentToMainActivity)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        var image0 : ImageView = findViewById(R.id.summon_image_0)
        if (image0.drawable != null) {
            outState.putParcelable("image", image0.drawable.toBitmap())
        }
        var image1 : ImageView = findViewById(R.id.summon_image_0)
        if (image1.drawable != null) {
            outState.putParcelable("image1", image1.drawable.toBitmap())
        }
        var image2 : ImageView = findViewById(R.id.summon_image_0)
        if (image2.drawable != null) {
            outState.putParcelable("image2", image2.drawable.toBitmap())
        }
        super.onSaveInstanceState(outState)
    }

}