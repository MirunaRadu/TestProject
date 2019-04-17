package com.example.test.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.test.R
import com.example.test.base.BaseActivity
import com.example.test.data.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity:BaseActivity<MainViewModel,MainViewModelFactory>(){

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        addItemButton.setOnClickListener {
            val itemName = itemNameEt.toString()
            if(!itemName.isBlank()) {
                val addItemCallback: (Item) -> Unit = {
                    Toast.makeText(baseContext, "$it added successfully!", Toast.LENGTH_SHORT).show()
                }
                viewModel.addItemToDatabase(itemName,addItemCallback)
            }
        }




    }
}
