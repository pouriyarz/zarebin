package com.example.viewmodel

import androidx.lifecycle.ViewModel

class ViewModelFactory(private val viewModelProviders: ViewModelProviders) :
    androidx.lifecycle.ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelProviders[modelClass]?.get() as T
    }
}