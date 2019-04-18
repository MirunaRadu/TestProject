package com.example.test.data

import com.example.test.data.model.Item
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class ItemRepository(private val itemDatabase: ItemDatabase) {

    fun getAllItems(): Observable<List<Item>> =
            itemDatabase.dao().getAll()
                    .subscribeOn(Schedulers.io())

    fun insertItem(item: Item): Observable<Long> =
            Observable.fromCallable {
                itemDatabase.dao().insert(item)
            }.subscribeOn(Schedulers.io())

    fun deleteItem(item: Item): Completable =
            Completable.fromAction { itemDatabase.dao().delete(item) }
                    .subscribeOn(Schedulers.io())
}