package com.an9ar.imgurgallery.views

import com.an9ar.imgurgallery.common.BaseView
import java.util.ArrayList

interface ImageListView : BaseView {

    fun initRV(imageUrl: ArrayList<String>, imageText: ArrayList<String>)
}