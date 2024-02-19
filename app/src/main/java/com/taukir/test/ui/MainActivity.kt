package com.taukir.test.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.taukir.test.R
import com.taukir.test.adapter.InspectionAdapter
import com.taukir.test.databinding.ActivityMainBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.interfaces.OnSwipeTouchListener
import com.taukir.test.models.InspectionModel
import com.taukir.test.utils.ClickFrom


class MainActivity : AppCompatActivity(),OnClickListener {


    private lateinit var binding: ActivityMainBinding
    var inspectionList: ArrayList<InspectionModel> = ArrayList()
    private lateinit var inspectionAdapter: InspectionAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.setTitle(R.string.inspection)

        inspectionList.add(InspectionModel("1","Weekly Inspection","Holiday In Express Franklin","19,Feb"))
        inspectionList.add(InspectionModel("2","Above-Property Assessment","Holiday Inn Express Franklin","20,Feb"))
        inspectionList.add(InspectionModel("3","Adult Shift Checklist","Holiday In Express Franklin","21,Feb"))
        inspectionList.add(InspectionModel("4","Do Not Disturb-Daily Tracking List","Holiday In Express Franklin","21,Feb"))
        inspectionList.add(InspectionModel("5","Do Not Disturb-Daily Tracking","Holiday In Express Franklin","22,Feb"))
        inspectionList.add(InspectionModel("6","Annual Inspection","Holiday In Express Franklin","23,Feb"))
        inspectionAdapter = InspectionAdapter(this)
        binding.inspectionTypeAdapter = inspectionAdapter
        binding.executePendingBindings()
        inspectionAdapter.submitList(inspectionList)



        binding.testTv.setOnTouchListener(object : OnSwipeTouchListener() {
            override fun onSwipeLeft() {
                Log.d("ViewSwipe", "Left")
            }

            override fun onSwipeRight() {
                Log.d("ViewSwipe", "Right")
            }
        })

    }

    override fun itemClick(itemData: Any, clickFrom: ClickFrom) {
        TODO("Not yet implemented")
    }

    override fun viewClick(clickFrom: ClickFrom) {
        TODO("Not yet implemented")
    }
}