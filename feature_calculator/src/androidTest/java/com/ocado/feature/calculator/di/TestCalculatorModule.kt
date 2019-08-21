package com.ocado.feature.calculator.di

import com.ocado.feature.calculator.CalculatorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestCalculatorModule {

    @ContributesAndroidInjector
    abstract fun calculatorFragment(): CalculatorFragment
}