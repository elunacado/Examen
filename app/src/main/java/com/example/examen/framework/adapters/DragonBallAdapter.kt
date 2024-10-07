package com.example.examen.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.framework.adapters.viewholders.DragonBallViewHolder
import com.example.examen.databinding.ItemDragonBallBinding

class DragonBallAdapter:RecyclerView.Adapter<DragonBallViewHolder>() {
    var data:ArrayList<com.example.examen.data.network.model.DragonBallObject> = ArrayList()
    lateinit var context: Context

    fun DragonBallAdapter(basicData : ArrayList<com.example.examen.data.network.model.DragonBallObject>, context:Context){
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: DragonBallViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragonBallViewHolder {
        val binding = ItemDragonBallBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DragonBallViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}