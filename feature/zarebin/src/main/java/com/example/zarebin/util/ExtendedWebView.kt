package com.example.zarebin.util

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

class ExtendedWebView : WebView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    fun canScrollHor(direction: Int): Boolean {
        val offset: Int = computeHorizontalScrollOffset()
        val range: Int = computeHorizontalScrollRange() - computeHorizontalScrollExtent()
        if (range == 0) return false
        return if (direction < 0) {
            offset > 0
        } else {
            offset < range - 1
        }
    }
}