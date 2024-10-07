// DragonBallAdapter.kt
package com.example.examen.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.model.DragonBallObject
import com.example.examen.framework.adapters.viewholders.DragonBallViewHolder
import com.example.examen.databinding.ItemDragonBallBinding

class DragonBallAdapter(private var data: List<DragonBallObject>, private val context: Context) :
    RecyclerView.Adapter<DragonBallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonBallViewHolder {
        val binding = ItemDragonBallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DragonBallViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DragonBallViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateData(newData: List<DragonBallObject>) {
        data = newData
        notifyDataSetChanged()
    }
}