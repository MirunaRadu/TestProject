package com.example.test.ui

import android.os.Bundle
import com.example.test.R
import com.example.test.base.BaseActivity

class MainActivity:BaseActivity<MainViewModel,MainViewModelFactory>(){

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
