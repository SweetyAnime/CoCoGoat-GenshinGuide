package com.cocogoat.genshinguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.ImageButton
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
        //link from firebase
        val yaewep =
            "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterButtons%2Fweaponpfp.png?alt=media&token=d4a75774-2ef3-47f3-9423-597cedde6acc"
        val aboutyae =
            "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Characters%2FYaeMiko%2Faboutyaemiko.png?alt=media&token=1b8f145b-100a-4ce2-a680-151274e09d17"
        val yaeart =
            "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterButtons%2Fartifactspfp.png?alt=media&token=61661080-542b-4547-8f74-680bbc45bc03"
        val yaeasc =
            "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterButtons%2Fascentionpfp.png?alt=media&token=fe28e5b3-be02-4f50-8ee7-b25f92f63109"
        val yaeconst = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterButtons%2Fconstellationpfp.png?alt=media&token=19faf939-1cb1-44de-8784-b312b96c5354"

        val yaetal = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterButtons%2Fskillspfp.png?alt=media&token=513fdaa0-c248-490a-a30a-491be73d5523"
        val yaepro = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterButtons%2Fvoiceoverspfp.png?alt=media&token=1c300a6d-835b-4a3b-8be1-a11c1e20170d"


        //about yae miko img
        val yaemikoabout = findViewById<ImageView>(R.id.aboutyaemikoImg)
        //videoview for yaemikovideo
        videoView = findViewById(R.id.yaemikovideo)
        // Load and play the video YaeMikoIdleAnimation from the Github URL
        val videoUrl =
            "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Characters%2FYaeMiko%2Fyaeidleanimation.mp4?alt=media&token=98c69830-8519-41f6-9b28-b0fa218240ca"  // Replace with your video URL
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


        //yae miko weapon image button
        val yaewepo = findViewById<ImageButton>(R.id.yaeweapon)
        yaewepo.setOnClickListener {
            val intent = Intent(this, YaeWeapon::class.java)
            startActivity(intent)
        }
        //picasso for yaewep
        Picasso.get()
            .load(yaewep)
            .into(yaewepo)


        //yaemiko artifact image button  CHANGE THE YAEWEPON TO YAEARTIFACT ACTIVITY!!!!!!!
        val yaeartif = findViewById<ImageView>(R.id.yaeartifact)
        yaeartif.setOnClickListener {
            val intent = Intent(this, YaeWeapon::class.java)
            startActivity(intent)
        }
        //Picasso For yaeart
        Picasso.get()
            .load(yaeart)
            .into(yaeartif)


        //yaeascention img button CHANGE THE YAEWEAPON TO YAEASCENTION ACTIVITY
        val yaeascent = findViewById<ImageView>(R.id.yaeascention)
        yaeascent.setOnClickListener {
            val intent = Intent(this, YaeWeapon::class.java)
            startActivity(intent)
        }
        //Picasso For yaeart
        Picasso.get()
            .load(yaeasc)
            .into(yaeascent)

        //yae constellation image button CHANGE THE YAEWEAPON TO YAEACONSTELLATION ACTIVITY
        val yaecon = findViewById<ImageView>(R.id.yaecons)
        yaecon.setOnClickListener {
            val intent = Intent(this, YaeWeapon::class.java)
            startActivity(intent)
        }
        //Picasso For yaeart
        Picasso.get()
            .load(yaeconst)
            .into(yaecon)


        //Image Button For Yae Talents CHANGE THE YAEWEAPON TO YAETALENTS ACTIVITY
        val yaeta = findViewById<ImageView>(R.id.yaetalents)
        yaeta.setOnClickListener {
            val intent = Intent(this, YaeWeapon::class.java)
            startActivity(intent)
        }
        //Picasso For yaeart
        Picasso.get()
            .load(yaetal)
            .into(yaeta)


        //Image Button For Yae Profile CHANGE THE YAEWEAPON TO YAEPROFILE ACTIVITY
        val yaeproff = findViewById<ImageView>(R.id.yaeprofile)
        yaeproff.setOnClickListener {
            val intent = Intent(this, YaeWeapon::class.java)
            startActivity(intent)
        }
        //Picasso
        Picasso.get()
            .load(yaepro)
            .into(yaeproff)


        //more added here





















    }
    //onstop method to save memory resource that cause lag on low end device
    override fun onStop() {
        super.onStop()
        // Cancel all Picasso requests associated with this activity
        Picasso.get().cancelTag(this)
    }
}