package com.example.examen.framework.adapters.viewholders

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.examen.data.network.model.DragonBallObject
import com.example.examen.databinding.ItemDragonBallBinding
import com.example.examen.domain.DragonBallInfoRequirements
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DragonBallViewHolder(private val binding: ItemDragonBallBinding) : RecyclerView.ViewHolder(binding.root) {
    private fun getDragonBallInfo(url:String, imageView: ImageView, context: Context){
        var dragonBallStringNumber:String = url.replace("https://pokeapi.co/api/v2/pokemon/","")
        dragonBallStringNumber = dragonBallStringNumber.replace("/","")
        val dragonBallNumber:Int = Integer.parseInt(dragonBallStringNumber)

        CoroutineScope(Dispatchers.IO).launch {
            val dragonBallInfoRequirement = DragonBallInfoRequirements()
            val result: DragonBallObject? = dragonBallInfoRequirement(dragonBallNumber)

            CoroutineScope(Dispatchers.Main).launch {
                val urlImage = result?.image.toString()

                val requestOptions =  RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }
    fun bind(item: DragonBallObject, context: Context){
        binding.Cname.text = item.name
    getDragonBallInfo(item.image ?: "", binding.Cphoto, context)    }
}