package com.inroad.di.calculator

import com.inroad.di.utils.FragmentScope
import com.ocado.feature.calculator.CalculatorFragment
import com.ocado.feature.calculator.CalculatorView
import dagger.Module
import dagger.Provides

@Module
class CalculatorFragmentModule {

    @Provides
    @FragmentScope
    fun provideCalculatorView(fragment: CalculatorFragment): CalculatorView = fragment
}