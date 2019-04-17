package com.example.test.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel:ViewModel(){
    private var compositeDisposable : CompositeDisposable? = null
    var hasNetworkConnection : Boolean = true

    init{
        compositeDisposable = CompositeDisposable()
    }

    override fun onCleared() {
        compositeDisposable?.clear()
        super.onCleared()
    }

    protected fun addDisposable(disposable : Disposable){
        compositeDisposable?.add(disposable)
    }
}