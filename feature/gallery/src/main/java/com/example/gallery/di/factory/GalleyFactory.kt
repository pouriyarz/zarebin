package com.example.gallery.di.factory

import com.example.dependencyinjection.ComponentFactory
import com.example.gallery.di.component.DaggerGalleryComponent
import com.example.gallery.di.component.GalleryComponent

object GalleyFactory : ComponentFactory<GalleryComponent>() {
    override fun create(): GalleryComponent {
        return DaggerGalleryComponent.factory().create()
    }
}