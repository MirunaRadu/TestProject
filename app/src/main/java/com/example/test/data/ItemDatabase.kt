package com.example.test.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.data.model.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun dao(): ItemDao

}