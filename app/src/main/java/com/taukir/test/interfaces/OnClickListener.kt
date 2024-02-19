package com.taukir.test.interfaces

import com.taukir.test.utils.ClickFrom

interface OnClickListener {

    fun itemClick(itemData:Any,clickFrom: ClickFrom)
    fun viewClick(clickFrom:ClickFrom)
}