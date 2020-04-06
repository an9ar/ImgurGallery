package com.an9ar.imgurgallery.adapters.image

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.an9ar.imgurgallery.R
import com.an9ar.imgurgallery.common.GlideApp
import com.an9ar.imgurgallery.models.Image
import java.util.*


class ImageListAdapter(ctx: Context, url: ArrayList<String>, text: ArrayList<String>) : PagedListAdapter<Image, ImageCardViewHolder>(
    diffCallback
) {

    internal var imageUrl: ArrayList<String>? = ArrayList()
    internal var imageText = ArrayList<String>()
    private val context : Context

    init {
        this.imageUrl = url
        this.imageText = text
        this.context = ctx
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ImageCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycled_list_item, parent, false)
        val holder = ImageCardViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(viewHolder: ImageCardViewHolder, i: Int) {
        val image : Image? = getItem(i)
        if (image?.type != null) {
            GlideApp.with(context)
                .load(image.link.toString())
                .placeholder(R.mipmap.refreshing)
                .error(R.drawable.ic_launcher_background)
                .into(viewHolder.image)
        }
        viewHolder.IMAGE_URL = image?.link
        viewHolder.text.text = image?.title
        viewHolder.id = image?.id
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean =
                oldItem == newItem
        }
    }
}