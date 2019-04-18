package com.example.test.ui.list

import androidx.lifecycle.ViewModel
import com.example.test.base.BaseViewModelFactory
import com.example.test.data.ItemRepository

@Suppress("UNCHECKED_CAST")
class ListViewModelFactory(private val repository: ItemRepository) : BaseViewModelFactory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ListViewModel(repository) as T
}