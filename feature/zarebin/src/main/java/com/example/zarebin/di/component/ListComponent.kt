package com.example.zarebin.di.component

import com.example.image.component.GlideComponent
import com.example.networking.component.NetworkComponent
import com.example.zarebin.di.module.ListModule
import com.example.zarebin.di.module.ListViewModelModule
import com.example.zarebin.di.scope.ZarebinScope
import com.example.zarebin.ui.fragment.ListFragment
import dagger.Component

@Component(
    dependencies = [NetworkComponent::class, GlideComponent::class],
    modules = [ListModule::class, ListViewModelModule::class]
)

@ZarebinScope
interface ListComponent {
    fun inject(listFragment: ListFragment)

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            glideComponent: GlideComponent,
        ): ListComponent
    }
}