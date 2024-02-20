package com.taukir.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taukir.test.databinding.InspectionItemRowBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.models.InspectionModel


class InspectionAdapter(private var clickListener: OnClickListener) :
    ListAdapter<InspectionModel, InspectionAdapter.InspectionAdapterViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<InspectionModel>() {
        override fun areItemsTheSame(
            oldItem: InspectionModel,
            newItem: InspectionModel
        ): Boolean = oldItem === newItem

        override fun areContentsTheSame(
            oldItem: InspectionModel,
            newItem: InspectionModel
        ): Boolean = oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspectionAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = InspectionItemRowBinding.inflate(layoutInflater, parent, false)
        return InspectionAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InspectionAdapterViewHolder, position: Int) {
        val inspectionItem = getItem(position)
        holder.binding.inspectionDetail = inspectionItem
        holder.binding.onClick = clickListener

    }

    class InspectionAdapterViewHolder(var binding: InspectionItemRowBinding) :
        RecyclerView.ViewHolder(binding.root)

}
