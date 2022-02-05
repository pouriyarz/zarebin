package com.example.base.behaviour

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding

fun <FragmentViewBinding : ViewBinding> com.example.base.BaseFragment<FragmentViewBinding>.navigate(
    destinationID: Int
) {
    try {
        findNavController().navigate(destinationID)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun <FragmentViewBinding : ViewBinding> com.example.base.BaseFragment<FragmentViewBinding>.navigateWithBundle(
    destinationID: Int, bundle: Bundle
) {
    try {
        findNavController().navigate(destinationID, bundle)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}