package com.cocogoat.genshinguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Characters : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        supportActionBar?.hide()

       // val yaeact = findViewById<ImageButton>(R.id.yaechr)
        //yaeact.setOnClickListener {
          //  val intent = Intent(this, Yaemikochr::class.java)
            //startActivity(intent)
        //}
    }
}