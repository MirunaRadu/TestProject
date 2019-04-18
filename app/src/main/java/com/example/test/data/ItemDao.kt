package com.example.test.data

import androidx.room.*
import com.example.test.data.model.Item
import io.reactivex.Observable

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item): Long

    @Delete
    fun delete(item:Item)

    @Query(Constants.ItemQueries.getAllQuery)
    fun getAll(): Observable<List<Item>>
}