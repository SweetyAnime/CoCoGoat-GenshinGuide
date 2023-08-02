package com.cocogoat.genshinguide

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class Dashboard : AppCompatActivity() {
    //links to load img from github
    private val charbtnUrl = "https://raw.githubusercontent.com/SweetyAnime/Resource_For_CoCoGoat-GenshinGuide/abc097c8610fb96cef55a220cb0c8ba5477c1f63/characters_btn.png" //character btn img
    private val wpnImageUrl = "https://raw.githubusercontent.com/SweetyAnime/Resource_For_CoCoGoat-GenshinGuide/abc097c8610fb96cef55a220cb0c8ba5477c1f63/weapons_btn.png" //wepon btn image
    private val artiimgUrl = "https://raw.githubusercontent.com/SweetyAnime/Resource_For_CoCoGoat-GenshinGuide/abc097c8610fb96cef55a220cb0c8ba5477c1f63/artifacts_btn.png"  //artifact btn image
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        //hides action bar
        supportActionBar?.hide()

        val chrbtn = findViewById<ImageButton>(R.id.chrbtn)
        val wpnbtn = findViewById<ImageButton>(R.id.wepbtn)
        val artibtn = findViewById<ImageButton>(R.id.artibtn)

        // Load the image from github to character button
        Picasso.get()
            .load(charbtnUrl)
            .into(chrbtn)

        //load img from github to wep button
        Picasso.get()
            .load(wpnImageUrl)
            .into(wpnbtn)

        //load img from github to arti button
        Picasso.get()
            .load(artiimgUrl)
            .into(artibtn)

        //by clicking chr wep it opens character activity
        chrbtn.setOnClickListener {
            val intent = Intent(this, Characters::class.java)
            startActivity(intent)
        }
    }
}
