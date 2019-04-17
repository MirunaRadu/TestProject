package com.example.test.data

import com.example.test.data.model.Item
import io.reactivex.Flowable

class ItemRepository(private val itemDatabase: ItemDatabase) {

    fun getAllItems(): Flowable<List<Item>> =
        itemDatabase.dao().getAll()

    fun insertItem(item: Item) =
        itemDatabase.dao().insert(item)

}