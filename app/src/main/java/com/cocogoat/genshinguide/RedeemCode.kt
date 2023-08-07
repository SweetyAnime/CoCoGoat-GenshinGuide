package com.cocogoat.genshinguide

import android.annotation.SuppressLint
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import android.widget.Toast

class RedeemCode : AppCompatActivity() {
    //var for temporary redeemcode 1
    private lateinit var redeemCodeTextView1: TextView
    private lateinit var timerTextView1: TextView
    private lateinit var countDownTimer1: CountDownTimer
    private lateinit var resourceTextView1: TextView


    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redeem_code)

        // ID's For Temporary Redeem Code 1
        redeemCodeTextView1 = findViewById(R.id.temporarycode1)
        timerTextView1 = findViewById(R.id.temporarycodetimer1)
        resourceTextView1 = findViewById(R.id.temporarycoderesource1)

        // Set a click listener to copy text to clipboard
        redeemCodeTextView1.setOnClickListener {
            copyTextToClipboard(redeemCodeTextView1.text.toString())
        }

        //toast notifaction
        redeemCodeTextView1.setOnClickListener {
            copyTextToClipboard(redeemCodeTextView1.text.toString())
            showToast("Text Copied")
        }

        // Timer initialization
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val endingDateString = "2023-09-01 09:00:00"
        val endingDate = sdf.parse(endingDateString)
        val currentTimeMillis = System.currentTimeMillis()
        val endingTimeMillis = endingDate?.time ?: currentTimeMillis
        countDownTimer1 = object : CountDownTimer(endingTimeMillis - currentTimeMillis, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                val days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished)
                val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished) % 24
                val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                val formattedTime = String.format(
                    "%d Days %dhr %dmin %dsec",
                    days, hours, minutes, seconds
                )
                timerTextView1.text = "Time left: $formattedTime"
            }

            override fun onFinish() {
                clearTextViews()
            }
        }
        countDownTimer1.start()
    }

    private fun copyTextToClipboard(text: String) {
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = android.content.ClipData.newPlainText("copiedText", text)
        clipboard.setPrimaryClip(clip)
    }

    private fun clearTextViews() {
        redeemCodeTextView1.text = ""
        timerTextView1.text = ""
        resourceTextView1.text = ""
    }
    // Define a showToast function
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer1.cancel()
    }
}
