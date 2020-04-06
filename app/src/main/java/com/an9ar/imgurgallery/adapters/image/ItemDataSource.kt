package com.an9ar.imgurgallery.adapters.image

import android.arch.paging.PageKeyedDataSource
import com.an9ar.imgurgallery.common.App
import com.an9ar.imgurgallery.models.Image
import com.an9ar.imgurgallery.models.ResponseImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemDataSource : PageKeyedDataSource<Int, Image>() {

    val FIRST_PAGE = 1
    private val SECTION = "top"
    private val SORT = "top"
    private val WINDOW = "all"
    private val VIRAL = true
    private val MATURE = true
    private val ALBUM_PREVIEW = false

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Image>) {
        App.message.getGallery(SECTION, SORT, WINDOW, FIRST_PAGE, VIRAL, MATURE, ALBUM_PREVIEW)
            .enqueue(object : Callback<ResponseImage> {

                override fun onResponse(call: Call<ResponseImage>, response: Response<ResponseImage>) {
                    callback.onResult(response.body()!!.getData()!!.filter { element -> element.type != null }, null, FIRST_PAGE+1)
                }

                override fun onFailure(call: Call<ResponseImage>, t: Throwable) {
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        App.message.getGallery(SECTION, SORT, WINDOW, params.key, VIRAL, MATURE, ALBUM_PREVIEW)
            .enqueue(object : Callback<ResponseImage> {

                override fun onResponse(call: Call<ResponseImage>, response: Response<ResponseImage>) {
                    callback.onResult(response.body()!!.getData()!!.filter { element -> element.type != null }, params.key+1)
                }

                override fun onFailure(call: Call<ResponseImage>, t: Throwable) {
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Image>) {
        App.message.getGallery(SECTION, SORT, WINDOW, params.key, VIRAL, MATURE, ALBUM_PREVIEW)
            .enqueue(object : Callback<ResponseImage> {

                override fun onResponse(call: Call<ResponseImage>, response: Response<ResponseImage>) {
                    val key = if (params.key > 1) params.key - 1 else null
                    callback.onResult(response.body()!!.getData()!!.filter { element -> element.type != null }, key)
                }

                override fun onFailure(call: Call<ResponseImage>, t: Throwable) {
                }
            })
    }
}

