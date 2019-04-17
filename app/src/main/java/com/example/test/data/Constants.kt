package com.example.test.data

import com.example.test.data.Constants.ItemEntity.TABLE_NAME

object Constants {
    const val DATABASE_NAME="test"
    object ItemEntity {
        const val TABLE_NAME = "item"
        const val COLUMN_INFO_NAME = "name"
    }

    object ItemQueries {
        const val getAllQuery = "SELECT * FROM $TABLE_NAME"
    }
}