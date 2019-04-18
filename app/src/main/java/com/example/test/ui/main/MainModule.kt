package com.example.test.ui.main

import com.example.test.data.ItemRepository
import com.example.test.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainModule{
    @Provides
    @ActivityScope
    internal fun provideMainViewModelFactory(repository:ItemRepository) =
        MainViewModelFactory(repository)


}