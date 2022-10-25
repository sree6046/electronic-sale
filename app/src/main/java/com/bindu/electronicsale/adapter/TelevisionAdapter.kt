package com.bindu.electronicsale.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bindu.electronicsale.databinding.AdapterTelevisionBinding
import com.bindu.electronicsale.model.Television

class TelevisionAdapter : RecyclerView.Adapter<MainViewHolder>()
{
    var televisions = mutableListOf<Television>()

    fun setMovieList(movies: List<Television>)
    {
        this.televisions = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder
    {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTelevisionBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int)
    {
        val television = televisions[position]
        holder.binding.tvTitle.text = television.name
        holder.binding.tvPrice.text = television.price.toString()

    }
    override fun getItemCount(): Int {
        return televisions.size
    }
}
class MainViewHolder(val binding: AdapterTelevisionBinding) : RecyclerView.ViewHolder(binding.root) {
}