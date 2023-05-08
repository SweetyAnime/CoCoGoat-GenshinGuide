package com.cocogoat.genshinguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cocogoat.genshinguide.databinding.ActivityYaemikochrBinding
import com.google.android.material.snackbar.Snackbar

class Yaemikochr : AppCompatActivity() {

    private lateinit var binding: ActivityYaemikochrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityYaemikochrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}