package com.taukir.test.utils

import com.taukir.test.R
import com.taukir.test.models.BannerImageModel
import com.taukir.test.models.BedroomsModel
import com.taukir.test.models.CleanlinessModel
import com.taukir.test.models.InspectionModel

val inspectionList = listOf(
    InspectionModel(
        "1",
        "Weekly Inspection",
        "Holiday In Express Franklin",
        "19,Feb"
    ),
    InspectionModel(
        "2",
        "Above-Property Assessment",
        "Holiday Inn Express Franklin",
        "20,Feb"
    ),
    InspectionModel(
        "3",
        "Adult Shift Checklist",
        "Holiday In Express Franklin",
        "21,Feb"
    ),
    InspectionModel(
        "4",
        "Do Not Disturb-Daily Tracking List",
        "Holiday In Express Franklin",
        "21,Feb"
    ),
    InspectionModel(
        "5",
        "Do Not Disturb-Daily Tracking",
        "Holiday In Express Franklin",
        "22,Feb"
    ),
    InspectionModel(
        "6",
        "Annual Inspection",
        "Holiday In Express Franklin",
        "23,Feb"
    )
)

val cleanlinessList = listOf(
    CleanlinessModel(
        "1",
        "Every inch of room has been sanitized",
        "",
        false
    ),
    CleanlinessModel(
        "2",
        "Every inch of room has been sanitized","",

        false

    ),
    CleanlinessModel(
        "3",
        "Every inch of room has been sanitized","",
        false

    )

)

val bedRoomsList = listOf(
    BedroomsModel(
        "1",
        "Every bedroom has been checked",
        "",
        false
    ),
    BedroomsModel(
        "2",
        "Every bedroom has been checked","",

        false

    ),
    BedroomsModel(
        "3",
        "Every bedroom has been checked","",
        false

    )

)

val bannerList = arrayListOf(
    BannerImageModel(
        "1",
        R.drawable.dress_wallpaper
    ),
    BannerImageModel(
        "2",
        R.drawable.welcome_street
    )

)
