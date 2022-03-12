package com.example.zarebin.di.module

import com.example.viewmodel.ViewModelFactory
import com.example.viewmodel.ViewModelProviders
import com.example.zarebin.data.repository.ZarebinRepository
import com.example.zarebin.data.repository.ZarebinRepositoryImp
import com.example.zarebin.data.service.ZarebinService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ListModule {

    @Provides
    fun provideViewModelFactory(viewModelProviders: ViewModelProviders): ViewModelFactory {
        return ViewModelFactory(viewModelProviders)
    }

    @Provides
    fun provideAddEventService(retrofit: Retrofit.Builder): ZarebinService {
        return retrofit.build().create(ZarebinService::class.java)
    }

    @Provides
    fun provideEventRepository(eventRepositoryImp: ZarebinRepositoryImp): ZarebinRepository =
        eventRepositoryImp
}