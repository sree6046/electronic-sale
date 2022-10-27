package com.bindu.electronicsale.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bindu.electronicsale.R
import com.bindu.electronicsale.adapter.MobileAdapter
import com.bindu.electronicsale.databinding.ActivityMobilesBinding
import com.bindu.electronicsale.viewmodel.MobilesActivityViewModel


class MobilesActivity : AppCompatActivity() {
    private val TAG = "MobilesActivity"
    private lateinit var binding: ActivityMobilesBinding
    lateinit var viewModel: MobilesActivityViewModel
    val adapter = MobileAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mobiles)

        title = "Mobiles"

        binding = ActivityMobilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MobilesActivityViewModel::class.java)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this@MobilesActivity,
                LinearLayoutManager.VERTICAL
            )
        )


        binding.addToCart.setOnClickListener {


        }


        viewModel.getMobileList().observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMobileList(it)
        })
        viewModel.getMobileList()
    }
}