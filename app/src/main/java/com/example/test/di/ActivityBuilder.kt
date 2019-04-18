package com.example.test.di

import com.example.test.di.scope.ActivityScope
import com.example.test.ui.main.MainActivity
import com.example.test.ui.main.MainFragmentProvider
import com.example.test.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ActivityScope
    @ContributesAndroidInjector(modules=[MainModule::class,MainFragmentProvider::class])
    abstract fun provideMainActivityInjector() : MainActivity
}