package com.example.networking.utils

object Holder {
    private var isAuthenticated: Boolean = false

    fun getAuthenticated(): Boolean {
        return isAuthenticated
    }

    fun setAuthenticated(isAuthenticated: Boolean) {
        Holder.isAuthenticated = isAuthenticated
    }
}