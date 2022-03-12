package com.example.zarebin.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.base.BaseFragment
import com.example.zarebin.R
import com.example.zarebin.databinding.FragmentPlayGoogleBinding
import com.example.zarebin.di.component.GooglePlayComponent
import com.example.zarebin.di.factory.GooglePlayFactory
import com.example.zarebin.ui.functionality.render

class GooglePlayFragment : BaseFragment<FragmentPlayGoogleBinding>(R.layout.fragment_play_google) {

    private var googlePlayComponent: GooglePlayComponent? = null

    override fun getViewBinding(): FragmentPlayGoogleBinding =
        FragmentPlayGoogleBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenToView()
        listenToViewModel()
    }

    override fun inject() {
        googlePlayComponent = GooglePlayFactory.create().also {
            it.inject(this)
        }
    }

    override fun release() {
        googlePlayComponent = null
    }

    override fun listenToView() = render()

    override fun listenToViewModel() {}
}