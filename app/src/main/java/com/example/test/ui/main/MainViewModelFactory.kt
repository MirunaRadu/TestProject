package com.example.test.ui.main

import androidx.lifecycle.ViewModel
import com.example.test.base.BaseViewModelFactory
import com.example.test.data.ItemRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val repository : ItemRepository) : BaseViewModelFactory{
    override fun <T : ViewModel?> create(modelClass: Class<T>) :T = MainViewModel(repository) as T
}