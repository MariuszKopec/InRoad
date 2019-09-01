package com.ocado.feature.base

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class BaseFragment : Fragment(), HasSupportFragmentInjector {
    @VisibleForTesting
    var isInjectionEnabled = true
    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context) {
        if (isInjectionEnabled) {
            AndroidSupportInjection.inject(this)
        }
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector
}