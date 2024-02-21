package com.taukir.test.ui

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.taukir.test.R
import com.taukir.test.adapter.BedRoomsAdapter
import com.taukir.test.adapter.CleanlinessAdapter
import com.taukir.test.adapter.InspectionAdapter
import com.taukir.test.databinding.ActivityMainBinding
import com.taukir.test.databinding.BottomSheetBinding
import com.taukir.test.interfaces.OnClickListener
import com.taukir.test.models.BedroomsModel
import com.taukir.test.models.CleanlinessModel
import com.taukir.test.utils.*

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var inspectionAdapter: InspectionAdapter
    private lateinit var cleanlinessAdapter: CleanlinessAdapter
    private lateinit var bedRoomsAdapter: BedRoomsAdapter
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var context: Context
    private lateinit var dialogBinding: BottomSheetBinding
    private lateinit var itemTouchHelper: ItemTouchHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.setTitle(R.string.inspection)
        binding.onClick = this
        context = this
        setUpAdapter()
    }

    private fun setUpAdapter() {
        inspectionAdapter = InspectionAdapter(this)
        binding.inspectionTypeAdapter = inspectionAdapter
        inspectionAdapter.submitList(inspectionList)
        binding.executePendingBindings()
    }

    override fun itemClick(itemData: Any, clickFrom: ClickFrom,type:String) {
        Log.d("bedrooms", type)

        when (clickFrom.name) {
            ClickFrom.FirstButtonClick.name -> {
                if (type == "cleanliness") {
                    itemData as CleanlinessModel
                    var index = 0
                    for (item in cleanlinessList) {
                        if (item.id == itemData.id) {
                            cleanlinessList[index].viewBarValue = "red"
                            break
                        }
                        index++
                    }
                    cleanlinessAdapter.notifyDataSetChanged()
                }else if (type == "bedrooms"){
                    Log.d("bedrooms", "itemClick: ")
                    itemData as BedroomsModel
                    var index = 0
                    for (item in bedRoomsList) {
                        if (item.id == itemData.id) {
                            bedRoomsList[index].viewBarValue = "red"
                            break
                        }
                        index++
                    }
                    bedRoomsAdapter.notifyDataSetChanged()
                }
            }
            ClickFrom.SecondButtonClick.name -> {
                if (type == "cleanliness") {
                    itemData as CleanlinessModel
                    var index = 0
                    for (item in cleanlinessList) {
                        if (item.id == itemData.id) {
                            cleanlinessList[index].viewBarValue = "orange"
                            break
                        }
                        index++
                    }
                    cleanlinessAdapter.notifyDataSetChanged()
                }else if (type == "bedrooms"){

                    itemData as BedroomsModel
                    var index = 0
                    for (item in bedRoomsList) {
                        if (item.id == itemData.id) {
                            bedRoomsList[index].viewBarValue = "orange"
                            break
                        }
                        index++
                    }
                    bedRoomsAdapter.notifyDataSetChanged()
                }
            }
            ClickFrom.ThirdButtonClick.name -> {
                if (type == "cleanliness") {
                    itemData as CleanlinessModel
                    var index = 0
                    for (item in cleanlinessList) {
                        if (item.id == itemData.id) {
                            cleanlinessList[index].viewBarValue = "gray"
                            break
                        }
                        index++
                    }
                    cleanlinessAdapter.notifyDataSetChanged()
                }else if (type == "bedrooms"){

                    itemData as BedroomsModel
                    var index = 0
                    for (item in bedRoomsList) {
                        if (item.id == itemData.id) {
                            bedRoomsList[index].viewBarValue = "gray"
                            break
                        }
                        index++
                    }
                    bedRoomsAdapter.notifyDataSetChanged()
                }
            }
            ClickFrom.FourthButtonClick.name -> {
                if (type == "cleanliness") {
                    itemData as CleanlinessModel
                    var index = 0
                    for (item in cleanlinessList) {
                        if (item.id == itemData.id) {
                            cleanlinessList[index].viewBarValue = "green"
                            break
                        }
                        index++
                    }
                    cleanlinessAdapter.notifyDataSetChanged()
                }else if (type == "bedrooms"){

                    itemData as BedroomsModel
                    var index = 0
                    for (item in bedRoomsList) {
                        if (item.id == itemData.id) {
                            bedRoomsList[index].viewBarValue = "green"
                            break
                        }
                        index++
                    }
                    bedRoomsAdapter.notifyDataSetChanged()
                }
            }
        }
    }


    override fun viewClick(clickFrom: ClickFrom) {
        when (clickFrom.name) {
            ClickFrom.ButtonClick.name -> {


            }

            ClickFrom.NavigateToBottomSheet.name -> {
                showBottomSheetDialog()
            }

            ClickFrom.OpenCloseCleanlinessList.name -> {
                dialogBinding.cleanlinessRecyclerView.visibility=View.VISIBLE
            }


            ClickFrom.OpenCloseBedroomsList.name -> {
                dialogBinding.bedroomsRecyclerView.visibility=View.VISIBLE
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
        setDialogBinding()
        bottomSheetDialog.show()
    }

    private fun setDialogBinding() {
        cleanlinessAdapter = CleanlinessAdapter(this)
        dialogBinding.cleanlinessAdapter = cleanlinessAdapter
        dialogBinding.onClick = this
        cleanlinessAdapter.submitList(cleanlinessList)

        bedRoomsAdapter = BedRoomsAdapter(this)
        dialogBinding.bedRoomsAdapter = bedRoomsAdapter
        dialogBinding.onClick = this
        bedRoomsAdapter.submitList(bedRoomsList)

        initializeCleanlinessListener()
        initializeBedRoomsListener()
        dialogBinding.executePendingBindings()
    }

    private fun initializeCleanlinessListener() {
        val simpleCallback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {

                val colorAlert =
                    ContextCompat.getColor(this@MainActivity, R.color.purple_700)
                val teal200 =
                    ContextCompat.getColor(this@MainActivity, R.color.purple_700)
                val defaultWhiteColor =
                    ContextCompat.getColor(this@MainActivity, R.color.white)

                // This is where to start decorating
                ItemDecorator.Builder(c, recyclerView, viewHolder, dX, actionState).set(
                    backgroundColorFromStartToEnd = colorAlert,
                    backgroundColorFromEndToStart = teal200,
                    textFromStartToEnd = "",
                    textFromEndToStart = "",
                    textColorFromStartToEnd = defaultWhiteColor,
                    textColorFromEndToStart = defaultWhiteColor,
                    iconTintColorFromStartToEnd = defaultWhiteColor,
                    iconTintColorFromEndToStart = defaultWhiteColor,
                    iconResIdFromStartToEnd = R.drawable.gray_btn_bg,
                    iconResIdFromEndToStart = R.drawable.green_btn_bg
                )

                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        cleanlinessList[position].isButtonVisible = true
                        cleanlinessAdapter.notifyDataSetChanged()
                    }
                }
                cleanlinessAdapter.notifyItemChanged(position)
            }
        }
        itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(dialogBinding.cleanlinessRecyclerView)
    }



    private fun initializeBedRoomsListener() {
        val simpleCallback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {

                val colorAlert =
                    ContextCompat.getColor(this@MainActivity, R.color.purple_700)
                val teal200 =
                    ContextCompat.getColor(this@MainActivity, R.color.purple_700)
                val defaultWhiteColor =
                    ContextCompat.getColor(this@MainActivity, R.color.white)

                // This is where to start decorating
                ItemDecorator.Builder(c, recyclerView, viewHolder, dX, actionState).set(
                    backgroundColorFromStartToEnd = colorAlert,
                    backgroundColorFromEndToStart = teal200,
                    textFromStartToEnd = "",
                    textFromEndToStart = "",
                    textColorFromStartToEnd = defaultWhiteColor,
                    textColorFromEndToStart = defaultWhiteColor,
                    iconTintColorFromStartToEnd = defaultWhiteColor,
                    iconTintColorFromEndToStart = defaultWhiteColor,
                    iconResIdFromStartToEnd = R.drawable.gray_btn_bg,
                    iconResIdFromEndToStart = R.drawable.green_btn_bg
                )

                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        bedRoomsList[position].isButtonVisible = true
                        bedRoomsAdapter.notifyDataSetChanged()
                    }
                }
                bedRoomsAdapter.notifyItemChanged(position)
            }
        }
        itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(dialogBinding.bedroomsRecyclerView)
    }
}