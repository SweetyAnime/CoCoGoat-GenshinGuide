package com.cocogoat.genshinguide

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import pl.droidsonroids.gif.GifDrawable

class Dashboard : AppCompatActivity() {
    private val wpnImageUrl = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Dashboard%2Fweapons_btn.png?alt=media&token=8e1239cc-5be3-4198-b187-aeea2400b330"
    private val artiImageUrl = "https://raw.githubusercontent.com/SweetyAnime/Resource_For_CoCoGoat-GenshinGuide/abc097c8610fb96cef55a220cb0c8ba5477c1f63/artifacts_btn.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()

        val wpnbtn = findViewById<ImageButton>(R.id.wepbtn)
        val artibtn = findViewById<ImageButton>(R.id.artibtn)
        val gifImageView = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.chrbtn)
        val transparentImageButton = findViewById<ImageButton>(R.id.overlaychrbtn)

        // Load images using Picasso
        Picasso.get().load(wpnImageUrl).into(wpnbtn)
        Picasso.get().load(artiImageUrl).into(artibtn)

        // Handle weapon button click
        wpnbtn.setOnClickListener {
            // Handle weapon button click
        }

        // Handle artifact button click
        artibtn.setOnClickListener {
            // Handle artifact button click

            // Set up GIF animation
            val gifDrawable = gifImageView.drawable as GifDrawable
            gifDrawable.loopCount = 10000 // Infinite loop
            gifDrawable.start()
        }

        // Handle transparentImageButton click
        transparentImageButton.setOnClickListener {
            // Open the CharactersActivity when the ImageButton is clicked
            val intent = Intent(this, Characters::class.java)
            startActivity(intent)
        }
    }
}
