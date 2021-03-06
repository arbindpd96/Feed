package com.example.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feed.R
import com.example.feed.adapter.ItemsAdapter
import com.example.feed.modals.response.Data
import com.example.feed.modals.response.Items
import kotlinx.android.synthetic.main.fragment_dynamic.*


class DynamicFragment : Fragment() {
    var adapter: ItemsAdapter? = null
    var data: Data? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getParcelable("item")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dynamic, container, false)
    }

    companion object {
        fun addfrag(item: Data): DynamicFragment {
            val fragment = DynamicFragment()
            val args = Bundle()
            args.putParcelable("item", item)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ItemsAdapter()
        item_list.adapter = adapter
        if (data?.items?.isNotEmpty() == true) {
            adapter?.itemList = data?.items as ArrayList<Items>
        }
    }
}