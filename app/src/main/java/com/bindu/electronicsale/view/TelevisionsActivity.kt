package com.bindu.electronicsale.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.bindu.electronicsale.R
import com.bindu.electronicsale.adapter.TelevisionAdapter
import com.bindu.electronicsale.database.CartData
import com.bindu.electronicsale.database.CartDatabase
import com.bindu.electronicsale.database.TelevisionDatabase
import com.bindu.electronicsale.databinding.ActivityTelevisionsBinding
import com.bindu.electronicsale.viewmodel.TelevisionsActivityViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class TelevisionsActivity : AppCompatActivity() {
    private val TAG = "TelevisionsActivity"
    private lateinit var binding: ActivityTelevisionsBinding
    lateinit var viewModel: TelevisionsActivityViewModel
    val adapter = TelevisionAdapter()
    lateinit var db: TelevisionDatabase
    lateinit var db1: CartDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_televisions)

        title = "Televisions"

        binding = ActivityTelevisionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            this@TelevisionsActivity,
            TelevisionDatabase::class.java,
            "televsion_table"
        ).build()
        db1 = Room.databaseBuilder(this@TelevisionsActivity, CartDatabase::class.java, "cart_table")
            .build()


        viewModel = ViewModelProvider(this).get(TelevisionsActivityViewModel::class.java)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        GlobalScope.async {
            var listt = db.televsionDao().getAll()

            for (i in 0..listt.size) {
                val cartData = CartData(
                    listt.get(i).itemid,
                    listt.get(i).type,
                    listt.get(i).name,
                    listt.get(i).description,
                    listt.get(i).year,
                    listt.get(i).price
                )
                db1.cartDao().insertAll(cartData)

                Log.e(
                    "DATA>>>>>>>>>>>>",
                    "pid: " + listt.get(i).pid +
                            "itemid: " + listt.get(i).itemid +
                            "\ntype: " + listt.get(i).type +
                            "\nname: " + listt.get(i).name +
                            "\ndesc: " + listt.get(i).description +
                            "\nyear: " + listt.get(i).year +
                            "\nprice: " + listt.get(i).price
                )
            }
        }

        binding.addToCart.setOnClickListener {

            GlobalScope.async {
                var listt = db.televsionDao().getAll()

                for (i in 0..listt.size) {
                    val cartData = CartData(
                        listt.get(i).itemid,
                        listt.get(i).type,
                        listt.get(i).name,
                        listt.get(i).description,
                        listt.get(i).year,
                        listt.get(i).price
                    )
                    db1.cartDao().insertAll(cartData)

                    Log.e(
                        "DATA>>>>>>>>>>>>",
                        "pid: " + listt.get(i).pid +
                                "itemid: " + listt.get(i).itemid +
                                "\ntype: " + listt.get(i).type +
                                "\nname: " + listt.get(i).name +
                                "\ndesc: " + listt.get(i).description +
                                "\nyear: " + listt.get(i).year +
                                "\nprice: " + listt.get(i).price
                    )
                }
            }
        }

        viewModel.getTelevisionList().observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })
        viewModel.getTelevisionList()
    }
}