package com.bindu.electronicsale.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bindu.electronicsale.R
import com.bindu.electronicsale.adapter.TelevisionAdapter
import com.bindu.electronicsale.databinding.ActivityTelevisionsBinding
import com.bindu.electronicsale.viewmodel.TelevisionsActivityViewModel


class TelevisionsActivity : AppCompatActivity() {
    private val TAG = "TelevisionsActivity"
    private lateinit var binding: ActivityTelevisionsBinding
    lateinit var viewModel: TelevisionsActivityViewModel
    val adapter = TelevisionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_televisions)

        title = "Televisions"

        binding = ActivityTelevisionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TelevisionsActivityViewModel::class.java)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        viewModel.getTelevisionList().observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
        viewModel.getTelevisionList()
    }
}