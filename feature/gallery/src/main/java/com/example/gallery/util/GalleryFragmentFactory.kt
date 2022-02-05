package com.example.gallery.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.gallery.di.scope.PickerBottomSheetScope
import com.example.gallery.ui.fragments.ChooseImageFragment

@PickerBottomSheetScope
class GalleryFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            ChooseImageFragment::class.java.name -> ChooseImageFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}