package com.taukir.test.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taukir.test.databinding.CleanlinessItemRowBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.models.CleanlinessModel


class CleanlinessAdapter(private var clickListener: OnClickListener) :
    ListAdapter<CleanlinessModel, CleanlinessAdapter.CleanlinessAdapterViewHolder>(Companion) {
    private lateinit var binding: CleanlinessItemRowBinding

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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CleanlinessAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = CleanlinessItemRowBinding.inflate(layoutInflater, parent, false)
        return CleanlinessAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CleanlinessAdapterViewHolder, position: Int) {
        val cleanlinessItem = getItem(position)
        holder.binding.cleanlinessDetail = cleanlinessItem
        holder.binding.onClick = clickListener

        if (cleanlinessItem.viewBarValue == "red") {
            holder.binding.cleanlinessItemViewBar.visibility=View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#E45233"))
        } else if (cleanlinessItem.viewBarValue == "ash") {
            holder.binding.cleanlinessItemViewBar.visibility=View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#848485"))
        } else if (cleanlinessItem.viewBarValue == "green") {
            holder.binding.cleanlinessItemViewBar.visibility=View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#55CC28"))
        } else if (cleanlinessItem.viewBarValue == "orange") {
            holder.binding.cleanlinessItemViewBar.visibility=View.VISIBLE
            holder.binding.cleanlinessItemViewBar.setBackgroundColor(Color.parseColor("#FFA500"))
        }else{
            holder.binding.cleanlinessItemViewBar.visibility=View.GONE
        }


//        holder.binding.isCleanlinessButtonVisible=true
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

    class CleanlinessAdapterViewHolder(var binding: CleanlinessItemRowBinding) :
        RecyclerView.ViewHolder(binding.root)

//    fun passAllButtonStatus(isClean: Boolean,position:Int) {
//        binding.isCleanlinessButtonVisible=isClean
//
//    }
}
