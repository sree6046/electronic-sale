package com.bindu.electronicsale.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.bindu.electronicsale.R
import com.bindu.electronicsale.adapter.CartAdapter
import com.bindu.electronicsale.database.CartData
import com.bindu.electronicsale.database.CartDatabase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


class CartActivity : AppCompatActivity() {
    lateinit var db1: CartDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        val cartEmpty = findViewById<TextView>(R.id.cart_empty)

        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<CartData>()
        db1 =
            Room.databaseBuilder(this@CartActivity, CartDatabase::class.java, "cart_table").build()
        val jobDeffered: Deferred<ArrayList<CartData>> = GlobalScope.async {

            val listt = db1.cartDao().getAll()
            for (i in 0..listt.size - 1) {
                var pid = listt.get(i).pid
                Log.e("PID>>>>>>", pid.toString())

                data.add(
                    CartData(
                        listt.get(i).itemid,
                        listt.get(i).type,
                        listt.get(i).name,
                        listt.get(i).description,
                        listt.get(i).year,
                        listt.get(i).price
                    )
                )
            }
            data
        }

        runBlocking {
            val listData = jobDeffered.await()

            if (listData.size > 0) {
                val adapter = CartAdapter(listData)
                recyclerview.adapter = adapter
                cartEmpty.visibility = View.INVISIBLE
            } else {
                cartEmpty.visibility = View.VISIBLE
            }
        }
    }

}
