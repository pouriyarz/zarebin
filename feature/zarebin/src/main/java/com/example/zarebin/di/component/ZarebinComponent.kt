package com.example.zarebin.di.component

import com.example.image.component.GlideComponent
import com.example.networking.component.NetworkComponent
import com.example.zarebin.di.scope.ZarebinScope
import com.example.zarebin.ui.fragment.ZarebinFragment
import dagger.Component

@Component(
    dependencies = [NetworkComponent::class, GlideComponent::class]
)

@ZarebinScope
interface ZarebinComponent {
    fun inject(zarebinFragment: ZarebinFragment)

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            glideComponent: GlideComponent,
        ): ZarebinComponent
    }
}