package com.example.zarebin.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.base.BaseFragment
import com.example.zarebin.R
import com.example.zarebin.databinding.FragmentZarebinBinding
import com.example.zarebin.di.component.ZarebinComponent
import com.example.zarebin.di.factory.ZarebinFactory
import com.example.zarebin.ui.functionality.render

class ZarebinFragment : BaseFragment<FragmentZarebinBinding>(R.layout.fragment_zarebin) {

    private var zarebinComponent: ZarebinComponent? = null

    override fun getViewBinding(): FragmentZarebinBinding =
        FragmentZarebinBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenToView()
        listenToViewModel()
    }

    override fun inject() {
        zarebinComponent = ZarebinFactory.create().also {
            it.inject(this)
        }
    }

    override fun release() {
        zarebinComponent = null
    }

    override fun listenToView() = render()

    override fun listenToViewModel() {}
}