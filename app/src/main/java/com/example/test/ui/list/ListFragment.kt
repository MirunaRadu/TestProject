package com.example.test.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.base.BaseFragment
import com.example.test.data.model.Item
import com.example.test.observeNonNull
import com.example.test.ui.adapter.ItemsAdapter
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : BaseFragment<ListViewModel, ListViewModelFactory>() ,ItemsAdapter.OnItemClickListener{
    private lateinit var itemsAdapter: ItemsAdapter
    override fun getViewModelClass(): Class<ListViewModel> = ListViewModel::class.java

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setUpObservers()
        viewModel.getAllLocalItems {
            Toast.makeText(context, "Items could not be loaded!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onItemClicked(item: Item) {
        viewModel.deleteItem(item){
            Toast.makeText(context,"$it was successfully added!",Toast.LENGTH_SHORT).show()
        }
    }

    private fun setRecyclerView() = with(listRecyclerView) {
        itemsAdapter = ItemsAdapter(this@ListFragment)
        adapter = itemsAdapter
        layoutManager = LinearLayoutManager(context)

    }

    private fun setUpObservers() {
        viewModel.itemList.observeNonNull(this@ListFragment) {
            itemsAdapter.reloadList(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
