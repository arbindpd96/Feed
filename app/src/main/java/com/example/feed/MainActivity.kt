package com.example.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feed.ui.HomeFragment
import com.example.feed.viewmodel.HomeFragmentViewModel
import org.koin.dsl.module
import org.koin.androidx.experimental.dsl.viewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        loadFeedHomeFrag()
    }

    private fun loadFeedHomeFrag() {
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, HomeFragment(), HomeFragment::class.simpleName).addToBackStack(HomeFragment::class.java.name)
            .commit()
    }
}

val mainActivityViewModelModule = module {
    viewModel<HomeFragmentViewModel>()
}