package com.example.image.module

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.example.context.qualifier.ApplicationContext
import com.example.dependencyinjection.libraries.LibrariesScope
import dagger.Module
import dagger.Provides
import org.example.design.R

@Module
object GlideModule {

    @LibrariesScope
    @Provides
    fun provideRequestOption(): RequestOptions {
        return RequestOptions().placeholder(R.drawable.image_default)
            .error(R.drawable.image_default)
    }

    @LibrariesScope
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(context)
            .setDefaultRequestOptions(requestOptions)
    }
}