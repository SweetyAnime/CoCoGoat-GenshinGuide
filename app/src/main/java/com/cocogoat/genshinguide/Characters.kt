package com.cocogoat.genshinguide

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class Characters : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        //hides action bar
        supportActionBar?.hide()
        //link from firebase resources
        val yaepfpUrl = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Characterpfp%2Fyae_miko_pfp.png?alt=media&token=4a6b94f9-fe27-4c3e-af57-91106b2aa150"

        //when yae img btn clicked it opens yaemiko activity
        val yaeact = findViewById<ImageButton>(R.id.yaechr)
        yaeact.setOnClickListener {
            val intent = Intent(this, Yaemiko::class.java)
            startActivity(intent)
        }
        //picasso for yaepfpurl
        Picasso.get()
            .load(yaepfpUrl)
            .into(yaeact)


        //add others below
    }
    //onstop method to save memory resource that cause lag on low end device
    override fun onStop() {
        super.onStop()
        // Cancel all Picasso requests associated with this activity
        Picasso.get().cancelTag(this)
    }
}