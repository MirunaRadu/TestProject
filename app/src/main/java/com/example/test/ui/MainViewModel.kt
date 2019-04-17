package com.example.test.ui

import android.util.Log
import com.example.test.base.BaseViewModel
import com.example.test.data.ItemRepository
import com.example.test.data.model.Item
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(private val repository: ItemRepository) : BaseViewModel(){

    fun addItemToDatabase(name:String,callback: (Item) -> Unit){
        addDisposable(repository.insertItem(Item(0,name)).
                observeOn(AndroidSchedulers.mainThread())
                .map{
                    Item(it.toInt(),name)
                }
                .subscribe ({
                    callback(it)
                },{
                    Log.e("MAINVIEWMODEL",it.toString())
                }))
    }
}