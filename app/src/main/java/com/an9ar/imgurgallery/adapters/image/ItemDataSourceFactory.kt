package com.an9ar.imgurgallery.adapters.image

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.DataSource.Factory
import android.arch.paging.PageKeyedDataSource
import com.an9ar.imgurgallery.models.Image


class ItemDataSourceFactory : Factory<Int, Image>() {

    private val itemLiveDataSource = MutableLiveData<PageKeyedDataSource<Int, Image>>()

    override fun create(): DataSource<Int, Image> {
        val itemDataSource = ItemDataSource()
        itemLiveDataSource.postValue(itemDataSource)
        return itemDataSource
    }

    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Image>> {
        return itemLiveDataSource
    }

}