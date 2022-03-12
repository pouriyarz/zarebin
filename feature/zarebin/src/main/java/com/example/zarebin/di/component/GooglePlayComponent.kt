package com.example.zarebin.di.component

import com.example.image.component.GlideComponent
import com.example.networking.component.NetworkComponent
import com.example.zarebin.di.scope.GooglePlayScope
import com.example.zarebin.ui.fragment.GooglePlayFragment
import dagger.Component

@Component(
    dependencies = [NetworkComponent::class, GlideComponent::class]
)

@GooglePlayScope
interface GooglePlayComponent {
    fun inject(googlePlayFragment: GooglePlayFragment)

    @Component.Factory
    interface Factory {
        fun create(
            networkComponent: NetworkComponent,
            glideComponent: GlideComponent,
        ): GooglePlayComponent
    }
}