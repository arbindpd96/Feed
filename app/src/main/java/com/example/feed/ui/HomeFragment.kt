package com.example.feed.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.feed.R
import com.example.feed.adapter.TabAdapter
import com.example.feed.modals.request.FeedRequest
import com.example.feed.modals.response.FeedResponse
import com.example.feed.networking.Status
import com.example.feed.viewmodel.HomeFragmentViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private val viewModel: HomeFragmentViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initObserver()

    }

    private fun initObserver() {
        viewModel.getFeedData(getFeedReq())

        viewModel.feedResponse.observe(viewLifecycleOwner) {
            Log.d("Mango","resp -> ${it.message},${it.status} , ${it.code} , ${it.payload}")
            when (it.status) {
                Status.SUCCESS -> {
                    if (it.payload?.data?.size ?: 0 > 0) setUpViewPager(it.payload)
                }
                Status.ERROR -> Toast.makeText(
                    context ?: return@observe, "${it.message}", Toast.LENGTH_LONG
                ).show()
            }

        }
    }

    private fun getFeedReq(): FeedRequest = FeedRequest(
        store_id = "3", u_id = "", access_type = "1", source = "mob"
    )

    private fun setUpViewPager(resp: FeedResponse?) {
        resp ?: return
        Log.d("Mango","size ${resp.data.size}")
        for (i in 0 until resp.data.size) {
            tab_mode.addTab(tab_mode.newTab().setText(resp.data[i].cat_name));
        }

        val adapter = TabAdapter(fragmentManager, tab_mode.tabCount,resp.data)
        viewpager.adapter = adapter;
        viewpager.offscreenPageLimit = 1;
        viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_mode));
    }
}

