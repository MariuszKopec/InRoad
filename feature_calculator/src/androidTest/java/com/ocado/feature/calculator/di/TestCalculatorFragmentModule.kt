package com.ocado.feature.calculator.di

import com.ocado.feature.calculator.CalculatorPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestCalculatorFragmentModule(private val calculatorPresenter: CalculatorPresenter) {

    @Provides
    @Singleton
    fun provideCalculatorPresenter(): CalculatorPresenter = calculatorPresenter
}