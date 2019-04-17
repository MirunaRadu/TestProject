package com.example.test.ui

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.base.BaseActivity
import com.example.test.data.model.Item
import com.example.test.observeNonNull
import com.example.test.ui.adapter.ItemsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel, MainViewModelFactory>(){
    private lateinit var itemsAdapter: ItemsAdapter

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        setUpListeners()
        viewModel.getAllLocalItems {
            Toast.makeText(this,"Items could not be loaded!",Toast.LENGTH_SHORT).show()
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

        viewModel.itemList.observeNonNull(this@MainActivity) {
            itemsAdapter.reloadList(it)
        }
    }

    private fun setRecyclerView() = with(listRecyclerView) {
        itemsAdapter = ItemsAdapter()
        adapter = itemsAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)

    }

    private fun handleItemAddedSuccessfully(item :Item){
        itemNameEt.text.clear()
        Toast.makeText(this,"$item added succesfully!",Toast.LENGTH_SHORT).show()
    }

}
