package com.bindu.electronicsale.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.bindu.electronicsale.R
import com.bindu.electronicsale.database.CartData
import com.bindu.electronicsale.database.CartDatabase
import com.bindu.electronicsale.database.TelevisionDatabase
import kotlinx.coroutines.*


class CartAdapter(private val mList: ArrayList<CartData>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    lateinit var db: TelevisionDatabase
    lateinit var db1: CartDatabase

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        db =
            Room.databaseBuilder(parent.context, TelevisionDatabase::class.java, "television_table")
                .build()
        db1 = Room.databaseBuilder(parent.context, CartDatabase::class.java, "cart_table").build()
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cart = mList[position]
        holder.tvTitle.text = cart.name
        holder.tvPrice.text = cart.price.toString()


        holder.ivDelete.setOnClickListener {

            val job: Deferred<Int> = GlobalScope.async {
                db1.cartDao().deleteByCartId(cart.itemid)
                db.televsionDao().deleteByTelevisionId(cart.itemid)
                position
            }

            runBlocking {
                val result = job.await()
                GlobalScope.launch {
                    val list = db1.cartDao().getAll()
                    Log.e("list>>>>>>>", list.size.toString() + "   " + list.toString())
                }

                var cart = mList.get(result)
                mList.remove(cart)
                notifyItemRemoved(result)
            }
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitlee)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPricee)
        val ivDelete: ImageView = itemView.findViewById(R.id.deleteIv)
    }
}

