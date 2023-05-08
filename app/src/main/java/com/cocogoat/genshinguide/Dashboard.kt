package com.cocogoat.genshinguide

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar?.hide()

        val chrbtn = findViewById<ImageButton>(R.id.chrbtn)
        chrbtn.setOnClickListener {
            val intent = Intent(this, Characters::class.java)
            startActivity(intent)
        }
    }
}