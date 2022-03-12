package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<FragmentViewBinding : ViewBinding>(@LayoutRes private val layout: Int) :
    Fragment(layout) {
    private var _binding: FragmentViewBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        inject()
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
        release()
    }

    abstract fun getViewBinding(): FragmentViewBinding
    abstract fun inject()
    abstract fun release()
    abstract fun listenToView()
    abstract fun listenToViewModel()
}