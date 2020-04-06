package com.an9ar.imgurgallery.views

import com.an9ar.imgurgallery.common.BaseView
import java.util.ArrayList

interface SelectedImageView : BaseView {

    fun initCommentRV(commentCaption: ArrayList<String>, commentAuthor: ArrayList<String>)
}