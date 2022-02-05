package com.example.gallery.di.module

import androidx.fragment.app.FragmentFactory
import com.example.gallery.util.GalleryFragmentFactory
import dagger.Module
import dagger.Provides

@Module
object GalleryModule {

    @Provides
    fun provideGalleryFragmentFactory(): FragmentFactory {
        return GalleryFragmentFactory()
    }
}