package com.bindu.electronicsale.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.bindu.electronicsale.database.CartDatabase
import com.bindu.electronicsale.database.TelevisionData
import com.bindu.electronicsale.database.TelevisionDatabase
import com.bindu.electronicsale.databinding.AdapterTelevisionBinding
import com.bindu.electronicsale.model.Television
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class TelevisionAdapter : RecyclerView.Adapter<TelevisionViewHolder>() {
    var televisions = mutableListOf<Television>()
    val list: MutableList<Int> = ArrayList()
    lateinit var db: TelevisionDatabase
    lateinit var db1: CartDatabase

    fun setMovieList(movies: List<Television>) {
        this.televisions = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelevisionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTelevisionBinding.inflate(inflater, parent, false)
        db = Room.databaseBuilder(parent.context, TelevisionDatabase::class.java, "televsion_table")
            .build()
        db1 = Room.databaseBuilder(parent.context, CartDatabase::class.java, "cart_table").build()
        return TelevisionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TelevisionViewHolder, position: Int) {
        val television = televisions[position]
        holder.binding.tvTitle.text = television.name
        holder.binding.tvPrice.text = "INR " + television.price.toString()

        GlobalScope.async {
            val listt = db1.cartDao().getAll()
            for (i in 0..listt.size) {
                if (listt.get(i).itemid == television.itemid) {
                    holder.binding.checkBox.isChecked = true
                }
            }
        }

        holder.binding.checkBox.setOnClickListener {

            val televisionData = TelevisionData(
                television.itemid,
                television.type,
                television.name,
                television.description,
                television.year,
                television.price
            )

            if (holder.binding.checkBox.isChecked) {
                GlobalScope.launch {
                    list.add(position)
                    db.televsionDao().insertAll(televisionData)
                    var listt = db.televsionDao().getAll()
                    Log.e("ADD>>>>>>>>>>>>", listt.size.toString() + " " + listt.toString())
                }
            } else {
                GlobalScope.launch {
                    list.remove(position)
                    db.televsionDao().deleteByTelevisionId(televisionData.itemid)
                    var listt = db.televsionDao().getAll()
                    Log.e("REMOVE>>>>>>>>>>>>", listt.size.toString() + " " + listt.toString())
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return televisions.size
    }
}

class TelevisionViewHolder(val binding: AdapterTelevisionBinding) :
    RecyclerView.ViewHolder(binding.root)