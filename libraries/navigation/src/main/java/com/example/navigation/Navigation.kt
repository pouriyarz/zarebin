package com.example.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions

fun NavController.move(
    desId: Int,
    bundle: Bundle?,
    navOptions: NavOptions = defaultNavOptions
) {
    navigate(desId, bundle, navOptions)
}

fun NavController.move(
    destination: Uri,
    navOptions: NavOptions = defaultNavOptions
) {
    navigate(destination, navOptions)
}

private val defaultNavOptions = NavOptions.Builder()
    .build()