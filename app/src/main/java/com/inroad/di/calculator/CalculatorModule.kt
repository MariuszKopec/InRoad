package com.inroad.di.calculator

import com.inroad.di.utils.FragmentScope
import com.ocado.feature.calculator.CalculatorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class CalculatorModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [CalculatorFragmentModule::class])
    abstract fun contributeCalculatorFragment(): CalculatorFragment
}