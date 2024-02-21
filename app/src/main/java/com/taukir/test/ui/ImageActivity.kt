package com.taukir.test.ui

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.taukir.test.adapter.BannerImagesAdapter
import com.taukir.test.R
import com.taukir.test.databinding.ActivityGalleryImageBinding
import com.taukir.test.models.BannerImageModel
import com.taukir.test.utils.AutoScrollViewPager
import com.taukir.test.utils.bannerList

class ImageActivity:AppCompatActivity() {

    private lateinit var binding: ActivityGalleryImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery_image)


    setUpViewPagerAdapter(bannerList)
    }

    private fun setUpViewPagerAdapter(images: ArrayList<BannerImageModel>) {
        binding.topViewpager.adapter = BannerImagesAdapter(this, images)
        binding.topViewpager.setInterval(2000)
        binding.topViewpager.setDirection(AutoScrollViewPager.Direction.RIGHT)
        binding.topViewpager.setCycle(true)
        binding.topViewpager.setBorderAnimation(false)
        binding.topViewpager.setSlideBorderMode(AutoScrollViewPager.SlideBorderMode.CYCLE)
        binding.topViewpager.startAutoScroll()
        binding.topViewpager.clipToPadding = false

        binding.circleIndicator.apply {
            setIndicatorGap(resources.getDimensionPixelOffset(R.dimen._2dp))
            setIndicatorDrawable(
                R.drawable.banner_indicator_normal, R.drawable.banner_indicator_focus
            )
            setIndicatorSize(
                resources.getDimensionPixelOffset(R.dimen._7dp),
                resources.getDimensionPixelOffset(R.dimen._7dp),
                resources.getDimensionPixelOffset(R.dimen._16dp),
                resources.getDimensionPixelOffset(R.dimen._7dp)
            )
            setupWithViewPager(binding.topViewpager)
        }

    }


}