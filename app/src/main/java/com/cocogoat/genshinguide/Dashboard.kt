package com.cocogoat.genshinguide

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import pl.droidsonroids.gif.GifDrawable

class Dashboard : AppCompatActivity() {
    //weaponimg
    private val wpnImageUrl =
        "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Dashboard%2Fweapons_btn.png?alt=media&token=8e1239cc-5be3-4198-b187-aeea2400b330"
    //artifactimg
    private val artiImageUrl =
        "https://raw.githubusercontent.com/SweetyAnime/Resource_For_CoCoGoat-GenshinGuide/abc097c8610fb96cef55a220cb0c8ba5477c1f63/artifacts_btn.png"
    //bannersimg
    private val banrsUrl =
        "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Dashboard%2Fbanner_btn.png?alt=media&token=2b978118-8450-4c7e-951e-b036ef0ccd52"
    //redeem codeimg
    private val redcod = "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Dashboard%2FRedeemCodes_btn.png?alt=media&token=078e9a99-2b7a-426e-a98b-58fef74d92e8"
    //dailycheckin img
    private val dailychk ="https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/Dashboard%2Fdailycheckin_btn.png?alt=media&token=3b1880fe-c54e-46cc-a8c1-79129b3500b4"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        supportActionBar?.hide()

        val wpnbtn = findViewById<ImageButton>(R.id.wepbtn)
        val artibtn = findViewById<ImageButton>(R.id.artibtn)
        val gifImageView = findViewById<pl.droidsonroids.gif.GifImageView>(R.id.chrbtn)
        val transparentImageButton = findViewById<ImageButton>(R.id.overlaychrbtn)
        // Load images using Picasso
        Picasso.get().load(wpnImageUrl).into(wpnbtn)
        Picasso.get().load(artiImageUrl).into(artibtn)
        // Handle weapon button click
        wpnbtn.setOnClickListener {
            // Handle weapon button click
        }

        // Handle artifact button click
        artibtn.setOnClickListener {
            // Handle artifact button click

            // Set up GIF animation
            val gifDrawable = gifImageView.drawable as GifDrawable
            gifDrawable.loopCount = 10000 // Infinite loop
            gifDrawable.start()
        }

        // Handle transparentImageButton click
        transparentImageButton.setOnClickListener {
            // Open the CharactersActivity when the ImageButton is clicked
            val intent = Intent(this, Characters::class.java)
            startActivity(intent)
        }

        //Banners Image Button
        val chbanner = findViewById<ImageView>(R.id.banners)
        chbanner.setOnClickListener {
            val intent = Intent(this, Characterbanners::class.java)
            startActivity(intent)
        }
        //Picasso For Banner Img btn
        Picasso.get()
            .load(banrsUrl)
            .into(chbanner)


        //Redeem Codes Image Button
        val redeemco = findViewById<ImageView>(R.id.redeemcodes)
        redeemco.setOnClickListener {
            val intent = Intent(this, RedeemCode::class.java)
            startActivity(intent)
        }
        //Picasso For redeem code Img btn
        Picasso.get()
            .load(redcod)
            .into(redeemco)


        //daily check-in img btn
        val dailyci = findViewById<ImageView>(R.id.dailychkin)
        dailyci.setOnClickListener {
            val intent = Intent(this, DailyCheckIn::class.java)
            startActivity(intent)
        }
        //Picasso For redeem code Img btn
        Picasso.get()
            .load(dailychk)
            .into(dailyci)

        //Support The Cause Img Btn
        val suppthecuz = findViewById<ImageView>(R.id.suppthecause)
        suppthecuz.setOnClickListener {
            val intent = Intent(this, Supportthecause::class.java)
            startActivity(intent)
        }


    }
        //onstop method to save memory resource that cause lag on low end device
        override fun onStop() {
            super.onStop()
            // Cancel all Picasso requests associated with this activity
            Picasso.get().cancelTag(this)
        }
}
