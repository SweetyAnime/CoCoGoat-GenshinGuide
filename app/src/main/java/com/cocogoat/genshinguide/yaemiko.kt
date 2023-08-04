package com.cocogoat.genshinguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.VideoView
import com.squareup.picasso.Picasso
import android.widget.ImageView



class Yaemiko : AppCompatActivity() {
    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yaemiko)
        //hides action bar
        supportActionBar?.hide()

        val aboutyae = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Characters%2FYaeMiko%2Faboutyaemiko.png?alt=media&token=1b8f145b-100a-4ce2-a680-151274e09d17"
        val yaemikoabout = findViewById<ImageView>(R.id.aboutyaemikoImg)

        videoView = findViewById(R.id.yaemikovideo)

        // Load and play the video YaeMikoIdleAnimation from the Github URL
        val videoUrl = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Characters%2FYaeMiko%2Fyaeidleanimation.mp4?alt=media&token=98c69830-8519-41f6-9b28-b0fa218240ca"  // Replace with your video URL
        val videoUri = Uri.parse(videoUrl)
        videoView.setVideoURI(videoUri)
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true  // Set the video to loop
            mediaPlayer.setVolume(0f, 0f) // Mute the audio
            videoView.start()
        }



        Picasso.get()
            .load(aboutyae)
            .into(yaemikoabout)

    }
}