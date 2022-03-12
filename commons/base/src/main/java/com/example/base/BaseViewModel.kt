package com.example.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    open fun loading(isLoading: Boolean) {}
    open fun <T> success(body: T) {}
    open fun failed(message: String) {}
}