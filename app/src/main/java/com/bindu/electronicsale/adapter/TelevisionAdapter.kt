package com.bindu.electronicsale.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bindu.electronicsale.databinding.AdapterTelevisionBinding
import com.bindu.electronicsale.model.Television

class TelevisionAdapter : RecyclerView.Adapter<TelevisionViewHolder>() {
    var televisions = mutableListOf<Television>()

    fun setMovieList(movies: List<Television>) {
        this.televisions = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelevisionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTelevisionBinding.inflate(inflater, parent, false)
        return TelevisionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TelevisionViewHolder, position: Int) {
        val television = televisions[position]
        holder.binding.tvTitle.text = television.name
        holder.binding.tvPrice.text = "INR " + television.price.toString()

    }

    override fun getItemCount(): Int {
        return televisions.size
    }
}

class TelevisionViewHolder(val binding: AdapterTelevisionBinding) :
    RecyclerView.ViewHolder(binding.root)