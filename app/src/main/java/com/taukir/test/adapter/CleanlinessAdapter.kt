package com.taukir.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taukir.test.databinding.CleanlinessItemRowBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.models.CleanlinessModel


class CleanlinessAdapter(var clickListener: OnClickListener) :
    ListAdapter<CleanlinessModel, CleanlinessAdapter.CleanlinessAdapterViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<CleanlinessModel>() {
        override fun areItemsTheSame(
            oldItem: CleanlinessModel,
            newItem: CleanlinessModel
        ): Boolean = oldItem === newItem

        override fun areContentsTheSame(
            oldItem: CleanlinessModel,
            newItem: CleanlinessModel
        ): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CleanlinessAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CleanlinessItemRowBinding.inflate(layoutInflater, parent, false)
        return CleanlinessAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CleanlinessAdapterViewHolder, position: Int) {
        val cleanlinessItem = getItem(position)
        holder.binding.cleanlinessDetail = cleanlinessItem
        holder.binding.onClick = clickListener

    }

    class CleanlinessAdapterViewHolder(var binding: CleanlinessItemRowBinding) :
        RecyclerView.ViewHolder(binding.root)

}