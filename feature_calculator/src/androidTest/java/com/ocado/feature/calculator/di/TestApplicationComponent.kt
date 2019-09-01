package com.ocado.feature.calculator.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [TestCalculatorFragmentModule::class, TestCalculatorModule::class, AndroidSupportInjectionModule::class])
interface TestApplicationComponent : AndroidInjector<TestApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TestApplication>() {
        abstract fun appModule(appModule: TestCalculatorFragmentModule): Builder
    }
}