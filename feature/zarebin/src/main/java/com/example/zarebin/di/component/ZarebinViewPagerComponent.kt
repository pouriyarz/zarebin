package com.example.zarebin.di.component

import com.example.image.component.GlideComponent
import com.example.networking.component.NetworkComponent
import com.example.zarebin.di.scope.ZarebinViewPagerScope
import com.example.zarebin.ui.fragment.ZarebinViewPagerFragment
import dagger.Component

@Component(
    dependencies = [NetworkComponent::class, GlideComponent::class]
)

@ZarebinViewPagerScope
interface ZarebinViewPagerComponent {
    fun inject(zarebinViewPagerFragment: ZarebinViewPagerFragment)

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            glideComponent: GlideComponent,
        ): ZarebinViewPagerComponent
    }
}