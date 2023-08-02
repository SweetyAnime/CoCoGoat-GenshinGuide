package com.cocogoat.genshinguide

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Characters : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        //hides action bar
        supportActionBar?.hide()

        //when yae img btn clicked it opens yaemiko activity
        val yaeact = findViewById<ImageButton>(R.id.yaechr)
        yaeact.setOnClickListener {
            val intent = Intent(this, Yaemiko::class.java)
            startActivity(intent)
        }
    }
}