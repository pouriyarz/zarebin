package com.example.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<ActivityViewBinding : ViewBinding>(
    @LayoutRes private val layout: Int
) :
    AppCompatActivity(layout) {
    private var _binding: ActivityViewBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = getViewBinding()
        inject()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    abstract fun inject()
    abstract fun release()
    abstract fun getViewBinding(): ActivityViewBinding
}