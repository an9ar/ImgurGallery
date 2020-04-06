package com.an9ar.imgurgallery.api

import com.an9ar.imgurgallery.models.ResponseComment
import com.an9ar.imgurgallery.models.ResponseImage
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ServerApi {

    @Headers("Authorization: Client-ID $AUTH")
    @GET("gallery/{section}/{sort}/{window}/{page}/")
    fun getGallery(@Path("section") section: String, @Path("sort") sort: String, @Path("window") window: String, @Path("page") page: Int, @Query("showViral") viral: Boolean, @Query("mature") mature: Boolean, @Query("album_previews") albumPreviews: Boolean): Call<ResponseImage>

    @Headers("Authorization: Client-ID $AUTH")
    @GET("gallery/{id}/comments/best/")
    fun getComments(@Path("id") id: String): Call<ResponseComment>


    companion object {
        const val AUTH = "fd568f82f1199e1"
    }

}