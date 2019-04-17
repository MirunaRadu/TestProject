package com.example.test.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test.data.model.Item
import io.reactivex.Observable

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item): Long

    @Query(Constants.ItemQueries.getAllQuery)
    fun getAll(): Observable<List<Item>>
}