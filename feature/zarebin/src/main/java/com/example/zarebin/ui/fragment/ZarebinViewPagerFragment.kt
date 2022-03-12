package com.example.zarebin.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.base.BaseFragment
import com.example.zarebin.R
import com.example.zarebin.databinding.FragmentViewpagerZarebinBinding
import com.example.zarebin.di.component.ZarebinViewPagerComponent
import com.example.zarebin.di.factory.ZarebinViewPagerFactory
import com.example.zarebin.ui.functionality.render

class ZarebinViewPagerFragment :
    BaseFragment<FragmentViewpagerZarebinBinding>(R.layout.fragment_viewpager_zarebin) {

    private var zarebinViewPagerComponent: ZarebinViewPagerComponent? = null

    override fun getViewBinding(): FragmentViewpagerZarebinBinding =
        FragmentViewpagerZarebinBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenToView()
        listenToViewModel()
    }

    override fun inject() {
        zarebinViewPagerComponent = ZarebinViewPagerFactory.create().also {
            it.inject(this)
        }
    }

    override fun release() {
        zarebinViewPagerComponent = null
    }

    override fun listenToView() = render()

    override fun listenToViewModel() {}
}