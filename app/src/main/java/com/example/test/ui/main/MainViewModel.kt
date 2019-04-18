package com.example.test.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.test.base.BaseViewModel
import com.example.test.data.ItemRepository
import com.example.test.data.model.Item
import io.reactivex.android.schedulers.AndroidSchedulers

class MainViewModel(private val repository: ItemRepository) : BaseViewModel(){


    fun addItemToDatabase(name:String, callback: (Item) -> Unit){
        addDisposable(repository.insertItem(Item(null,name)).
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