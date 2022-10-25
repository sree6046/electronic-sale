package com.bindu.electronicsale

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bindu.electronicsale.adapter.TelevisionAdapter
import com.bindu.electronicsale.databinding.ActivityMainBinding
import com.bindu.electronicsale.model.Television
import com.bindu.electronicsale.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity()
{
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    val adapter = TelevisionAdapter()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.recyclerView.adapter = adapter

        viewModel.getTelevisionList().observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
        viewModel.getTelevisionList()
    }
}