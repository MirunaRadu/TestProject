package com.example.test.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.test.data.Constants.ItemEntity.COLUMN_INFO_NAME
import com.example.test.data.Constants.ItemEntity.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = COLUMN_INFO_NAME)
    var name: String
)