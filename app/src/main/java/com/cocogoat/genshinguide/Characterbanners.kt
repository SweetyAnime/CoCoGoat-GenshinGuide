package com.cocogoat.genshinguide

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.TimeZone
import java.util.concurrent.TimeUnit


class Characterbanners : AppCompatActivity() {

    //Timer
    private lateinit var countdownTextView: TextView
    private lateinit var countDownTimer: CountDownTimer

    @SuppressLint("SimpleDateFormat", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characterbanners)
        //hides actionbar
        supportActionBar?.hide()


        // Timer
        countdownTextView = findViewById(R.id.countdownTextView)

        // Set your ending date and time (format: "yyyy-MM-dd HH:mm:ss")
        val endingDateString = "2023-08-16 15:30:00"
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        sdf.timeZone = TimeZone.getTimeZone("Asia/Kolkata") // Replace with your desired timezone
        val endingDate = sdf.parse(endingDateString)?.time ?: 0

        val currentTimeMillis = System.currentTimeMillis()
        val timeUntilEndMillis = endingDate - currentTimeMillis

        countDownTimer = object : CountDownTimer(timeUntilEndMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
                val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished) % 24
                val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                val formattedTime = String.format(
                    "%d Days %d Hours %d Minutes %d Seconds",
                    days, hours, minutes, seconds
                )
                countdownTextView.text = formattedTime
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                countdownTextView.text = "Banner Ended!"
            }
        }
        countDownTimer.start()

            //characterbanner1 image
            val ongchrban1 =
                "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterBanners%2FOngoingBanners%2FKokomi-Banner-3.8.webp?alt=media&token=690fb93f-d022-49e5-8f3f-246ff44a14f9"
            val ongchrban11 = findViewById<ImageView>(R.id.characterbanner1)

            Picasso.get()
                .load(ongchrban1)
                .into(ongchrban11)

            //characterbanner2 Image
            val ongchrban2 =
                "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterBanners%2FOngoingBanners%2FWanderer-Banner-3.8.webp?alt=media&token=0bdf7ea3-faea-409b-938c-2fb2bba322f5"
            val ongchrban22 = findViewById<ImageView>(R.id.characterbanner2)

            Picasso.get()
                .load(ongchrban2)
                .into(ongchrban22)

            //weaponbanner1 Image
            val ongwepban1 =
                "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterBanners%2FOngoingBanners%2FWeapon-Banner-2-3.8.webp?alt=media&token=b1db66bc-8627-4ae6-9f8b-018440e8af75"
            val ongwepban11 = findViewById<ImageView>(R.id.weaponbanner)

            Picasso.get()
                .load(ongwepban1)
                .into(ongwepban11)

            //upcoming characterbanner1 image
            val upchrban1 =
                "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterBanners%2FUpcomingBanners%2FPh-1%20Lyney.jpg?alt=media&token=6151ec06-8d5c-43f8-b2a9-15114c2b81d5"
            val upchrban11 = findViewById<ImageView>(R.id.upcomingcharacterbanner1)

            Picasso.get()
                .load(upchrban1)
                .into(upchrban11)

            //upcoming characterbanner2 image
            val upchrban2 =
                "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterBanners%2FUpcomingBanners%2FPh-1%20Yelan.jpg?alt=media&token=cf617ac6-c947-406b-8583-2fbf03e1d83a"
            val upchrban22 = findViewById<ImageView>(R.id.upcomingcharacterbanner2)

            Picasso.get()
                .load(upchrban2)
                .into(upchrban22)

            //upcoming weapon banner1 image
            val upwepban1 =
                "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterBanners%2FUpcomingBanners%2FPh-1%20Epitome%20Invocation%20Weapon.jpg?alt=media&token=c257acf8-165b-4ac9-a8f1-adc069a97194"
            val upwepban11 = findViewById<ImageView>(R.id.upcomingweaponbanner)

            Picasso.get()
                .load(upwepban1)
                .into(upwepban11)

            //upcoming character banner 3
            val upchrban3 =
                "https://firebasestorage.googleapis.com/v0/b/cocogoat-genshinguide.appspot.com/o/CharacterBanners%2FUpcomingBanners%2Fph-2%20preview.jpg?alt=media&token=f764c8bb-9a20-4dc5-87a4-f580dae9c4f6"
            val upchrban33 = findViewById<ImageView>(R.id.upcomingcharacterbanner3)

            Picasso.get()
                .load(upchrban3)
                .into(upchrban33)


        }

        //onstop method to save memory resource that cause lag on low end device
        override fun onStop() {
            super.onStop()
            // Cancel all Picasso requests associated with this activity
            Picasso.get().cancelTag(this)
        }
}
