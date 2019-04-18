package com.example.test.ui.list

import com.example.test.data.ItemRepository
import com.example.test.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class ListModule{

    @Provides
    @FragmentScope
    fun provideListViewModelFactory(repository: ItemRepository) : ListViewModelFactory = ListViewModelFactory(repository)
}