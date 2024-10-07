package com.example.examen.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.model.DragonBallObject
import com.example.examen.databinding.ItemDragonBallBinding
import com.example.examen.framework.adapters.viewholders.ZeroKiViewHolder

class ZeroKiAdapter(
    private var items: List<DragonBallObject>,
    private val context: Context
) : RecyclerView.Adapter<ZeroKiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZeroKiViewHolder {
        val binding = ItemDragonBallBinding.inflate(LayoutInflater.from(context), parent, false)
        return ZeroKiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ZeroKiViewHolder, position: Int) {
        holder.bind(items[position], context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateData(newItems: List<DragonBallObject>) {
        items = newItems
        notifyDataSetChanged()
    }
}