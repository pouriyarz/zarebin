package com.example.zarebin.ui.functionality

import android.annotation.SuppressLint
import android.webkit.WebViewClient
import com.example.zarebin.ui.fragment.GooglePlayFragment

@SuppressLint("SetJavaScriptEnabled")
fun GooglePlayFragment.render() {
    binding.apply {
        webView.settings.useWideViewPort = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("http://play.google.com/")
    }
}