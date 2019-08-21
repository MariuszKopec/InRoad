package com.inroad.di

import com.inroad.AndroidApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<AndroidApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AndroidApplication>()
}