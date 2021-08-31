package com.example.feed.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.feed.modals.response.Data
import com.example.feed.ui.DynamicFragment


class TabAdapter(fm: FragmentManager?, var mNumOfTabs: Int , private val item  : List<Data>) : FragmentStatePagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
        return DynamicFragment.addfrag(item[position])
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}