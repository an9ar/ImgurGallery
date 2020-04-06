package com.an9ar.imgurgallery.adapters.image

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PagedList
import com.an9ar.imgurgallery.models.Image

class ItemViewModel : ViewModel() {

    var itemPagedList: LiveData<PagedList<Image>>
    var liveDataSource: LiveData<PageKeyedDataSource<Int, Image>>

    init {
        val itemDataSourceFactory = ItemDataSourceFactory()
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource()

        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build()

        itemPagedList = LivePagedListBuilder(itemDataSourceFactory, pagedListConfig)
            .build()
    }


}