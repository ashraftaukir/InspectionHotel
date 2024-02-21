package com.taukir.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.taukir.test.databinding.ImageRowBinding
import com.taukir.test.models.BannerImageModel


class BannerImagesAdapter(
    private val context: Context,
    private var images: List<BannerImageModel>?
) : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount() = images!!.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ImageRowBinding.inflate(LayoutInflater.from(context), container, false)
        binding.riBanner.setImageResource(images?.get(position)?.imageIcon!!)
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}