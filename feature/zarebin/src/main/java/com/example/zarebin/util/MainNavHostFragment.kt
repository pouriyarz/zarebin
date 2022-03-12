package com.example.zarebin.util

import android.content.Context
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.example.zarebin.ui.MainActivity

class MainNavHostFragment : NavHostFragment() {

    companion object {
        private const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        fun create(@NavigationRes navigationResource: Int): MainNavHostFragment {
            var bundle: Bundle? = null
            if (navigationResource != 0) {
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, navigationResource)
            }
            val navHostFragment = MainNavHostFragment()
            if (bundle != null) {
                navHostFragment.arguments = bundle
            }
            return navHostFragment
        }
    }

    override fun onAttach(context: Context) {
        childFragmentManager.fragmentFactory =
            (activity as MainActivity).fragmentFactory
        super.onAttach(context)
    }
}