package com.example.zarebin.di.module

import androidx.lifecycle.ViewModel
import com.example.viewmodel.ViewModelKey
import com.example.zarebin.ui.fragment.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel
}