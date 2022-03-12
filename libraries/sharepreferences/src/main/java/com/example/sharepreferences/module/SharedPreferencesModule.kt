package com.example.sharepreferences.module

import android.content.Context
import android.content.SharedPreferences
import com.example.context.qualifier.ApplicationContext
import com.example.dependencyinjection.libraries.LibrariesScope
import com.example.sharepreferences.utils.Constant
import dagger.Module
import dagger.Provides

@Module
object SharedPreferencesModule {

    @Provides
    @LibrariesScope
    @JvmStatic
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(Constant.name, Context.MODE_PRIVATE)
    }
}