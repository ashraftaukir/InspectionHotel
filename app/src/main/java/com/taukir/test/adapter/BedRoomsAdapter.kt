package com.taukir.test.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taukir.test.databinding.CleanlinessItemRowBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.interfaces.OnSwipeTouchListener
import com.taukir.test.models.CleanlinessModel


class BedRoomsAdapter(private var clickListener: OnClickListener) :
    ListAdapter<CleanlinessModel, BedRoomsAdapter.BedRoomsAdapterViewHolder>(Companion) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BedRoomsAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CleanlinessItemRowBinding.inflate(layoutInflater, parent, false)
        return BedRoomsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BedRoomsAdapterViewHolder, position: Int) {
        val cleanlinessItem = getItem(position)
        holder.binding.cleanlinessDetail = cleanlinessItem
        holder.binding.onClick = clickListener
//        holder.binding.bedroomsItemConstraintLayout.setOnTouchListener(object : OnSwipeTouchListener() {
//            override fun onSwipeLeft() {
//                Log.d("ViewSwipe", "onSwipeLeft: ")
//                holder.binding.differentBtnConstraintLayout.visibility = View.VISIBLE
//            }
//
//            override fun onSwipeRight() {
//                Log.d("ViewSwipe", "onSwipeRight")
//
//            }
//        })

    }

    class BedRoomsAdapterViewHolder(var binding: CleanlinessItemRowBinding) :
        RecyclerView.ViewHolder(binding.root)

}
