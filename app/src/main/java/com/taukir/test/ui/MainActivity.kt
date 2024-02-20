package com.taukir.test.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.taukir.test.R
import com.taukir.test.adapter.BedRoomsAdapter
import com.taukir.test.adapter.CleanlinessAdapter
import com.taukir.test.adapter.InspectionAdapter
import com.taukir.test.databinding.ActivityMainBinding
import com.taukir.test.databinding.BottomSheetBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.interfaces.OnSwipeTouchListener
import com.taukir.test.models.CleanlinessModel
import com.taukir.test.models.InspectionModel
import com.taukir.test.utils.ClickFrom


class MainActivity : AppCompatActivity(), OnClickListener {


    private lateinit var binding: ActivityMainBinding
    private var inspectionList: ArrayList<InspectionModel> = ArrayList()
    private var cleanlinessList: ArrayList<CleanlinessModel> = ArrayList()
    private lateinit var inspectionAdapter: InspectionAdapter
    private lateinit var cleanlinessAdapter: CleanlinessAdapter
    private lateinit var bedRoomsAdapter: BedRoomsAdapter
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var context: Context
    private lateinit var dialogBinding: BottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.setTitle(R.string.inspection)
        binding.onClick = this
        context = this

        inspectionList.add(
            InspectionModel(
                "1",
                "Weekly Inspection",
                "Holiday In Express Franklin",
                "19,Feb"
            )
        )
        inspectionList.add(
            InspectionModel(
                "2",
                "Above-Property Assessment",
                "Holiday Inn Express Franklin",
                "20,Feb"
            )
        )
        inspectionList.add(
            InspectionModel(
                "3",
                "Adult Shift Checklist",
                "Holiday In Express Franklin",
                "21,Feb"
            )
        )
        inspectionList.add(
            InspectionModel(
                "4",
                "Do Not Disturb-Daily Tracking List",
                "Holiday In Express Franklin",
                "21,Feb"
            )
        )
        inspectionList.add(
            InspectionModel(
                "5",
                "Do Not Disturb-Daily Tracking",
                "Holiday In Express Franklin",
                "22,Feb"
            )
        )
        inspectionList.add(
            InspectionModel(
                "6",
                "Annual Inspection",
                "Holiday In Express Franklin",
                "23,Feb"
            )
        )


        cleanlinessList.add(
            CleanlinessModel(
                "1",
                "Every inch of room has been sanitized",
            )
        )
        cleanlinessList.add(
            CleanlinessModel(
                "2",
                "Every inch of room has been sanitized",
            )
        )
        cleanlinessList.add(
            CleanlinessModel(
                "3",
                "Every inch of room has been sanitized",
            )
        )

        inspectionAdapter = InspectionAdapter(this)
        binding.inspectionTypeAdapter = inspectionAdapter
        binding.executePendingBindings()
        inspectionAdapter.submitList(inspectionList)

    }


    override fun viewClick(clickFrom: ClickFrom) {
        when (clickFrom.name) {
            ClickFrom.ButtonClick.name -> {

            }

            ClickFrom.NavigateToBottomSheet.name -> {
                showBottomSheetDialog()

            }

            ClickFrom.OpenCloseCleanlinessList.name -> {

                if (dialogBinding.cleannessFirstItemConstraintLayout.isVisible) {
                    dialogBinding.cleannessFirstItemConstraintLayout.visibility = View.GONE
                } else {
                    dialogBinding.cleannessFirstItemConstraintLayout.visibility = View.VISIBLE
                }
            }

            ClickFrom.OpenCloseBedroomsList.name -> {

//                dialogBinding.bedroomsRecyclerView.visibility=View.VISIBLE
            }


            ClickFrom.CancelBottomSheet.name -> {
                bottomSheetDialog.dismiss()
            }


        }

    }

    private fun showBottomSheetDialog() {

        bottomSheetDialog = BottomSheetDialog(context)
        dialogBinding =
            BottomSheetBinding.inflate(LayoutInflater.from(context))
        bottomSheetDialog.setCancelable(false)
        bottomSheetDialog.setContentView(dialogBinding.root)
        dialogBinding.onClick = this
//        setDialogBinding()
        bottomSheetDialog.show()

        dialogBinding.cleannessFirstItemConstraintLayout.setOnTouchListener(object : OnSwipeTouchListener() {
            override fun onSwipeLeft() {
                dialogBinding.differentBtnConstraintLayout.visibility = View.VISIBLE
            }

            override fun onSwipeRight() {

            }
        })


    }

    private fun setDialogBinding() {
        cleanlinessAdapter = CleanlinessAdapter(this)
        dialogBinding.cleanlinessAdapter = cleanlinessAdapter
        dialogBinding.onClick = this
        cleanlinessAdapter.submitList(cleanlinessList)


        bedRoomsAdapter = BedRoomsAdapter(this)
        dialogBinding.bedRoomsAdapter = bedRoomsAdapter
        dialogBinding.onClick = this
        bedRoomsAdapter.submitList(cleanlinessList)
        dialogBinding.executePendingBindings()


        dialogBinding.executePendingBindings()
    }
}