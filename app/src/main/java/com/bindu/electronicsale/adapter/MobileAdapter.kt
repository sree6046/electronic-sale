package com.bindu.electronicsale.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bindu.electronicsale.databinding.AdapterMobileBinding
import com.bindu.electronicsale.model.Mobile

class MobileAdapter : RecyclerView.Adapter<MobileViewHolder>() {
    var mobiles = mutableListOf<Mobile>()

    fun setMobileList(movies: List<Mobile>) {
        this.mobiles = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobileViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMobileBinding.inflate(inflater, parent, false)
        return MobileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MobileViewHolder, position: Int) {
        val mobile = mobiles[position]
        holder.binding.tvTitle.text = mobile.name
        holder.binding.tvPrice.text = "INR " + mobile.price.toString()

    }

    override fun getItemCount(): Int {
        return mobiles.size
    }
}

class MobileViewHolder(val binding: AdapterMobileBinding) : RecyclerView.ViewHolder(binding.root)