package com.example.gallery.ui

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import com.example.base.BaseActivity
import com.example.gallery.R
import com.example.gallery.databinding.GalleryActivityBinding
import com.example.gallery.di.component.GalleryComponent
import com.example.gallery.di.factory.GalleyFactory
import com.example.gallery.util.GalleryNavHostFragment
import javax.inject.Inject

class GalleryActivity :
    BaseActivity<GalleryActivityBinding>(R.layout.gallery_activity) {

    @Inject
    lateinit var galleryFragmentFactory: FragmentFactory

    var galleryComponent: GalleryComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createHost()
    }

    override fun getViewBinding(): GalleryActivityBinding =
        GalleryActivityBinding.inflate(layoutInflater)

    override fun inject() {
        galleryComponent = GalleyFactory.create().also {
            it.inject(this)
        }
    }

    override fun release() {
        galleryComponent = null
        finish()
    }

    private fun createHost() {
        val host = supportFragmentManager.findFragmentById(R.id.gallery_fragment_container)
        if (host != null)
            return
        val navHost = GalleryNavHostFragment.create(R.navigation.navigation_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.gallery_fragment_container, navHost, "authenticate")
            .setPrimaryNavigationFragment(navHost).commit()
    }
}