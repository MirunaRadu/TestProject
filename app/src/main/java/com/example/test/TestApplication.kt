package com.example.test

import com.example.test.di.DaggerAppComponent
import dagger.android.AndroidInjector

import dagger.android.DaggerApplication
class TestApplication : DaggerApplication(){


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .also {
                it.inject(this)
            }

}