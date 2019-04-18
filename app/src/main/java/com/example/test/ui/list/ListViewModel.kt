package com.example.test.ui.list

import androidx.lifecycle.MutableLiveData
import com.example.test.base.BaseViewModel
import com.example.test.data.ItemRepository
import com.example.test.data.model.Item
import io.reactivex.android.schedulers.AndroidSchedulers

class ListViewModel(private val repository: ItemRepository) : BaseViewModel() {
    var itemList = MutableLiveData<List<Item>>()

    fun getAllLocalItems(handleError: (String) -> Unit) {
        addDisposable(repository.getAllItems()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    itemList.value = it
                }, {
                    handleError(it.message.toString())
                }))
    }

    fun deleteItem(item:Item,result: (Item) -> Unit){
        addDisposable(disposable = repository.deleteItem(item)
                .observeOn(AndroidSchedulers.mainThread())
                .toObservable<Item>()
                .subscribe {
                    result(item)
                })
    }

}