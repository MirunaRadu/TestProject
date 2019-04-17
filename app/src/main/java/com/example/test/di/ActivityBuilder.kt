package com.example.test.di

import com.example.test.di.scope.ActivityScope
import com.example.test.ui.MainActivity
import com.example.test.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ActivityScope
    @ContributesAndroidInjector(modules=[MainModule::class])
    abstract fun provideMainActivityInjector() : MainActivity
}