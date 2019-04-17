package com.example.test.data

import android.content.Context
import androidx.room.Room
import com.example.test.data.Constants.DATABASE_NAME
import com.example.test.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @ApplicationScope
    @Provides
    fun provideDatabase(context: Context): ItemDatabase =
        Room.databaseBuilder(context, ItemDatabase::class.java, DATABASE_NAME).build()

    @ApplicationScope
    @Provides
    fun provideItemRepository(database: ItemDatabase) : ItemRepository = ItemRepository(database)

}