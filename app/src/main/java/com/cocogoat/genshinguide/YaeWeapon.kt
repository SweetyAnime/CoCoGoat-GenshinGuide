package com.cocogoat.genshinguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso

class YaeWeapon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yae_weapon)























    }
    //onstop method to save memory resource that cause lag on low end device
    override fun onStop() {
        super.onStop()
        // Cancel all Picasso requests associated with this activity
        Picasso.get().cancelTag(this)
    }
}