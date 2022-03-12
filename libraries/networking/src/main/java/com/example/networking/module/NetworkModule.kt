package com.example.networking.module

import android.content.Context
import android.content.SharedPreferences
import com.example.context.BuildConfig
import com.example.context.qualifier.ApplicationContext
import com.example.dependencyinjection.libraries.LibrariesScope
import com.example.networking.factory.HaCallAdapterFactory
import com.example.networking.utils.Builder
import com.example.sharepreferences.utils.Constant
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @Provides
    @LibrariesScope
    @JvmStatic
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            Constant.name,
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @LibrariesScope
    @JvmStatic
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().serializeNulls().setLenient().create()
    }

    @Provides
    @LibrariesScope
    @JvmStatic
    fun provideHttpLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Provides
    @LibrariesScope
    @JvmStatic
    fun provideClient(
        sharedPreferences: SharedPreferences,
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return Builder.generateClient(sharedPreferences, loggingInterceptor)
    }

    @Provides
    @LibrariesScope
    @JvmStatic
    fun provideNetWorkBuilder(
        gsonBuilder: Gson,
        client: Lazy<OkHttpClient>,
    ): Retrofit.Builder {
        return Retrofit.Builder().baseUrl("https://mytodotes.herokuapp.com/api/")
            .callFactory(object : Call.Factory {
                override fun newCall(request: Request): Call {
                    return client.get().newCall(request)
                }
            })
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .addCallAdapterFactory(HaCallAdapterFactory.create())
    }
}