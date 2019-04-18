package com.example.test.ui.main

import com.example.test.di.scope.FragmentScope
import com.example.test.ui.list.ListFragment
import com.example.test.ui.list.ListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentProvider{
    @FragmentScope
    @ContributesAndroidInjector(modules = [ListModule::class])
    abstract fun provideListFragment() : ListFragment
}