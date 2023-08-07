package com.cocogoat.genshinguide

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class DailyCheckIn : AppCompatActivity() {
    private lateinit var webView: WebView
    private var loggedIn = false

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_check_in)
        //hides action bar
        supportActionBar?.hide()

        webView = findViewById(R.id.dailycheckin)
        val webSettings: WebSettings = webView.settings

        // Prevent loading of mixed content (HTTP content on HTTPS page)
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_NEVER_ALLOW

        // Other security settings
        webSettings.javaScriptEnabled = true // Enable JavaScript
        webSettings.domStorageEnabled = true // Enable DOM Storage (for cookies)
        webSettings.cacheMode = WebSettings.LOAD_DEFAULT

        // Set a WebViewClient to handle URL loading
        webView.webViewClient = CustomWebViewClient()

        // Load the website
        webView.loadUrl("https://act.hoyolab.com/ys/event/signin-sea-v3/index.html?act_id=e202102251931481")
    }

    private inner class CustomWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url = request?.url.toString()

            if (url.startsWith("yourapp://facebook-login")) {
                launchChromeCustomTab(url)
                return true
            }

            return super.shouldOverrideUrlLoading(view, request)
        }
    }

    private fun launchChromeCustomTab(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder().build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // If user is logged in, handle back press according to your app logic
        if (loggedIn) {
            // Implement your desired behavior
        } else {
            super.onBackPressed()
        }
    }
}
