package com.example.gallery.ui.fragments

import android.net.Uri
import android.os.Bundle
import android.view.View
import com.bumptech.glide.RequestManager
import com.example.base.BaseFragment
import com.example.gallery.R
import com.example.gallery.databinding.ChooseImageFragmentBinding
import com.example.gallery.di.component.ChooseImageComponent
import com.example.gallery.di.factory.ChooseImageFactory
import com.example.gallery.ui.adapter.ImagesAdapter
import com.example.gallery.ui.functionalities.render
import javax.inject.Inject

class ChooseImageFragment :
    BaseFragment<ChooseImageFragmentBinding>(R.layout.choose_image_fragment) {

    @Inject
    lateinit var requestManager: RequestManager

    private var chooseImageComponent: ChooseImageComponent? = null
    lateinit var imagesAdapter: ImagesAdapter
    val filesList: ArrayList<Uri> = ArrayList()

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