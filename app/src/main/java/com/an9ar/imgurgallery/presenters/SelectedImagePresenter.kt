package com.an9ar.imgurgallery.presenters

import com.an9ar.imgurgallery.common.App
import com.an9ar.imgurgallery.common.BasePresenter
import com.an9ar.imgurgallery.models.ResponseComment
import com.an9ar.imgurgallery.views.SelectedImageView
import com.arellomobile.mvp.InjectViewState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

@InjectViewState
class SelectedImagePresenter : BasePresenter<SelectedImageView>() {

    var imageURL : String? = null
    var imageTitle : String? = null
    var imageID : String? = null
    var commentCaptions = ArrayList<String>()
    var commentAuthors = ArrayList<String>()

    fun getCardInfo(url : String, title : String, id : String){
        imageURL = url
        imageTitle = title
        imageID = id
    }

    fun getComments(){
        App.message.getComments(imageID!!).enqueue(object : Callback<ResponseComment> {

            override fun onResponse(call: Call<ResponseComment>, response: Response<ResponseComment>) {
                val iterate = response.body()!!.getData()!!.listIterator()
                while (iterate.hasNext()) {
                    val value = iterate.next()
                    commentCaptions.add(value.comment!!)
                    commentAuthors.add(value.author!!)
                }
                viewState.initCommentRV(commentCaptions, commentAuthors)
            }

            override fun onFailure(call: Call<ResponseComment>, t: Throwable) {
            }
        })
    }
}