package com.example.zarebin.di.module

import androidx.fragment.app.FragmentFactory
import com.example.zarebin.util.MainFragmentFactory
import dagger.Module
import dagger.Provides

@Module
object MainModule {

    @Provides
    fun provideAuthenticateFragmentFactory(): FragmentFactory {
        return MainFragmentFactory()
    }
}