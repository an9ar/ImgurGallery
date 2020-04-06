package com.an9ar.imgurgallery.presenters

import com.an9ar.imgurgallery.common.BasePresenter
import com.an9ar.imgurgallery.views.ImageListView
import com.arellomobile.mvp.InjectViewState

@InjectViewState
class ImageListPresenter : BasePresenter<ImageListView>() {

    var imageUrl = ArrayList<String>()
    var imageText = ArrayList<String>()

    fun getList(){
        viewState.initRV(imageUrl, imageText)
    }

}
