package com.example.examen.framework.adapters.viewholders

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.examen.R
import com.example.examen.data.network.model.DragonBallObject
import com.example.examen.databinding.ItemDragonBallBinding


class DragonBallViewHolder(private val binding: ItemDragonBallBinding) : RecyclerView.ViewHolder(binding.root) {

    private fun loadImage(url: String, imageView: ImageView, context: Context) {
        val requestOptions = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .fitCenter()
            .priority(Priority.HIGH)

        Glide.with(context).load(url)
            .apply(requestOptions)
            .into(imageView)
    }

    fun bind(item: DragonBallObject, context: Context) {
        binding.Cname.text = item.name
        val imageUrl = item.image

        if (imageUrl != null && imageUrl.isNotEmpty()) {
            loadImage(imageUrl, binding.Cphoto, context)
        } else {
            binding.Cphoto.setImageResource(R.drawable.ic_launcher_background) // Use a placeholder image
        }
    }
}