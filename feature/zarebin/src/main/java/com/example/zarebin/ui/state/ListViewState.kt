package com.example.zarebin.ui.state

import androidx.annotation.Keep

@Keep
data class ListViewState<T>(
    val isLoading: Boolean = false,
    var message: String? = null,
    var response: T? = null
)