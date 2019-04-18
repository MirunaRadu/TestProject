package com.example.test.base

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, VMF : BaseViewModelFactory> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: VMF

    protected lateinit var viewModel: VM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
    }

    protected abstract fun getViewModelClass(): Class<VM>

}