package com.inroad.di

import com.inroad.MainActivity
import com.inroad.di.calculator.CalculatorModule
import com.inroad.di.utils.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [CalculatorModule::class])
    abstract fun contributeMainActivity(): MainActivity
}