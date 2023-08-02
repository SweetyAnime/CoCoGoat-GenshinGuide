package com.cocogoat.genshinguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash : AppCompatActivity() {
    //duration to wait to open next activity
    private val splash: Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //hides action bar
        supportActionBar?.hide()

        //opens dashboard activity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }, splash)
    }
}