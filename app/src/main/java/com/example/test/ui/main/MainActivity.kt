package com.example.test.ui.main

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.base.BaseActivity
import com.example.test.data.model.Item
import com.example.test.observeNonNull
import com.example.test.ui.adapter.ItemsAdapter
import com.example.test.ui.list.ListFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, MainViewModelFactory>(){


    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,
                ListFragment.newInstance()).commit()
        setUpListeners()
        navigation_bar.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.home_navigation->{
                    Toast.makeText(this,"Home reclicked!",Toast.LENGTH_SHORT).show()
                }
            }
        }
        navigation_bar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_navigation->{
                    Toast.makeText(this,"Home clicked!",Toast.LENGTH_SHORT).show()
                    Log.d("LALALA","Clicked")
                    true}
                R.id.music_navigation->{
                    Toast.makeText(this,"Music clicked",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

    }


    private fun setUpListeners() {
        addItemButton.setOnClickListener {
            val itemName = itemNameEt.text.toString()
            if (!itemName.isBlank()) {
                viewModel.addItemToDatabase(itemName) {
                    handleItemAddedSuccessfully(it)
                }
            }
        }

    }

    private fun handleItemAddedSuccessfully(item :Item){
        itemNameEt.text.clear()
        Toast.makeText(this,"$item added succesfully!",Toast.LENGTH_SHORT).show()
    }

}
