package com.taukir.test.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taukir.test.databinding.BedroomsItemRowBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.models.BedroomsModel


class BedRoomsAdapter(private var clickListener: OnClickListener) :
    ListAdapter<BedroomsModel, BedRoomsAdapter.BedRoomsAdapterViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<BedroomsModel>() {
        override fun areItemsTheSame(
            oldItem: BedroomsModel,
            newItem: BedroomsModel
        ): Boolean = oldItem === newItem

        override fun areContentsTheSame(
            oldItem: BedroomsModel,
            newItem: BedroomsModel
        ): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BedRoomsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BedroomsItemRowBinding.inflate(layoutInflater, parent, false)
        return BedRoomsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BedRoomsAdapterViewHolder, position: Int) {
        val bedroomsItem = getItem(position)
        holder.binding.bedroomsDetail = bedroomsItem
        holder.binding.onClick = clickListener

        if (bedroomsItem.viewBarValue == "red") {
            holder.binding.cleanlinessItemViewBar.visibility= View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#E45233"))
        } else if (bedroomsItem.viewBarValue == "gray") {
            holder.binding.cleanlinessItemViewBar.visibility= View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#848485"))
        } else if (bedroomsItem.viewBarValue == "green") {
            holder.binding.cleanlinessItemViewBar.visibility= View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#55CC28"))
        } else if (bedroomsItem.viewBarValue == "orange") {
            holder.binding.cleanlinessItemViewBar.visibility= View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#FFA500"))
        }else{
            holder.binding.cleanlinessItemViewBar.visibility= View.GONE
        }


    }

    class BedRoomsAdapterViewHolder(var binding: BedroomsItemRowBinding) :
        RecyclerView.ViewHolder(binding.root)

}
