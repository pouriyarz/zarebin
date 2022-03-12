package com.example.zarebin.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.zarebin.di.scope.MainScope
import com.example.zarebin.ui.fragment.GooglePlayFragment

@MainScope
class MainFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            GooglePlayFragment::class.java.name -> GooglePlayFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}