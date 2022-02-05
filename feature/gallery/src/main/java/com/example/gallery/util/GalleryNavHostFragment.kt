package com.example.gallery.util

import android.content.Context
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.example.gallery.ui.GalleryActivity

class GalleryNavHostFragment : NavHostFragment() {

    companion object {
        private const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        fun create(@NavigationRes navigationResource: Int): GalleryNavHostFragment {
            var bundle: Bundle? = null
            if (navigationResource != 0) {
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, navigationResource)
            }
            val navHostFragment = GalleryNavHostFragment()
            if (bundle != null) {
                navHostFragment.arguments = bundle
            }
            return navHostFragment
        }
    }

    override fun onAttach(context: Context) {
        childFragmentManager.fragmentFactory =
            (activity as GalleryActivity).galleryFragmentFactory
        super.onAttach(context)
    }
}