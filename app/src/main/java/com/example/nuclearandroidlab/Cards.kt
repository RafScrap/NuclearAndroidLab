package com.example.nuclearandroidlab

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import kotlin.random.Random

class Cards {
    private var listImageView : List<ImageView>;

    private fun generateCharacter(imageView: ImageView) : Unit {
        if (Random.nextInt(99) < 51) {
            imageView.setImageResource(R.drawable.character_lan_wangji);
        }
        else {
            imageView.setImageResource(R.drawable.character_nie_mingjue);
        }
    }

    constructor(listImageView : List<ImageView>) {
        this.listImageView = listImageView;
        for (image in this.listImageView) {
            image.setImageDrawable(null)
        }
    }

    fun changeImage() : Unit {
        for (image in listImageView) {
            generateCharacter(image);
        }
    }

    fun setImage(index: Int, btmp: Bitmap) : Unit {
        listImageView[index].setImageBitmap(btmp)
    }

    /*fun getImageResources() : MutableList <Bitmap?> {
        var res : MutableList <Bitmap?> = mutableListOf()
        for (image in listImageView) {
            val draw : Drawable? = image.drawable
            if (draw != null) {
                res.add(draw.toBitmap())
            }
            else res.add(null)
        }
        return res;

    }*/

    /*fun changeImageOne() : Unit {
        for (image in listImageView) {
            image.setImageDrawable(null);
        }
        generateCharacter(listImageView[0])
    }*/
}

