package com.inroad

import com.inroad.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class AndroidApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<AndroidApplication> = DaggerAppComponent.builder().create(this)
}