package com.example.gallery.ui.fragments

import android.os.Bundle
import android.view.View
import com.example.base.BaseFragment
import com.example.gallery.R
import com.example.gallery.databinding.ChooseImageFragmentBinding
import com.example.gallery.di.component.ChooseImageComponent
import com.example.gallery.di.factory.ChooseImageFactory
import com.example.gallery.ui.functionalities.render

class ChooseImageFragment :
    BaseFragment<ChooseImageFragmentBinding>(R.layout.choose_image_fragment) {

    private var chooseImageComponent: ChooseImageComponent? = null

    override fun getViewBinding(): ChooseImageFragmentBinding =
        ChooseImageFragmentBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenToView()
    }

    override fun inject() {
        chooseImageComponent = ChooseImageFactory.create().also {
            it.inject(this)
        }
    }

    override fun release() {
        chooseImageComponent = null
    }

    override fun listenToView() = render()
}