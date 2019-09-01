package com.ocado.feature.calculator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer

fun launchCalculatorFragment(presenter: CalculatorPresenter): FragmentScenario<CalculatorFragment> {
    return launchFragmentInContainer(
        factory = object : FragmentFactory() {
            override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
                return CalculatorFragment().also {
                    it.isInjectionEnabled = false
                    it.presenter = presenter
                }
            }
        },
        themeResId = R.style.AppTheme)
}