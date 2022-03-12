package com.example.zarebin.ui.functionality

import android.annotation.SuppressLint
import android.webkit.WebViewClient
import com.example.zarebin.ui.fragment.ZarebinFragment

@SuppressLint("SetJavaScriptEnabled")
fun ZarebinFragment.render() {
    binding.apply {
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com/")
    }
}