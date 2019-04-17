package com.example.test.base

import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel, VMF : BaseViewModelFactory> :LifecycleOwner,DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory : VMF

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(getViewModelClass())
    }

    protected abstract fun getViewModelClass() : Class<VM>
}