package com.example.zarebin.ui

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import com.example.base.BaseActivity
import com.example.zarebin.R
import com.example.zarebin.databinding.MainActivityBinding
import com.example.zarebin.di.component.MainComponent
import com.example.zarebin.di.factory.MainFactory
import com.example.zarebin.util.MainNavHostFragment
import javax.inject.Inject

class MainActivity :
    BaseActivity<MainActivityBinding>(R.layout.main_activity) {

    @Inject
    lateinit var fragmentFactory: FragmentFactory

    var mainComponent: MainComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createHost()
    }

    override fun getViewBinding(): MainActivityBinding =
        MainActivityBinding.inflate(layoutInflater)

    override fun inject() {
        mainComponent = MainFactory.create().also {
            it.inject(this)
        }
    }

    override fun release() {
        mainComponent = null
        finish()
    }

    private fun createHost() {
        val host = supportFragmentManager.findFragmentById(R.id.main_fragment_container)
        if (host != null)
            return
        val navHost = MainNavHostFragment.create(R.navigation.navigation_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, navHost, "main")
            .setPrimaryNavigationFragment(navHost).commit()
    }
}