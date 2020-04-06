package com.an9ar.imgurgallery.adapters.comment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.an9ar.imgurgallery.R
import com.an9ar.imgurgallery.common.GlideApp
import java.util.*

class CommentListAdapter(ctx: Context, caption: ArrayList<String>, author: ArrayList<String>) : RecyclerView.Adapter<CommentViewHolder>(){

    var commentCaption: ArrayList<String>? = ArrayList()
    var commentAuthor = ArrayList<String>()
    private val context : Context

    init {
        this.commentCaption = caption
        this.commentAuthor = author
        this.context = ctx
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): CommentViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.comment_list_item, parent, false)
        return CommentViewHolder(v)
    }

    override fun getItemCount(): Int {
        return if (commentCaption == null) 0 else commentCaption!!.size
    }

    override fun onBindViewHolder(commentViewHolder: CommentViewHolder, i: Int) {
        if ((commentCaption!![i].startsWith("http://i.imgur.com/"))||(commentCaption!![i].startsWith("https://i.imgur.com/"))){
            if (commentCaption!![i].endsWith("gifv")) {
                commentViewHolder.author.text = commentAuthor[i]
                commentViewHolder.caption.visibility = View.GONE
                commentViewHolder.image.visibility = View.VISIBLE
                GlideApp.with(context)
                    .load(commentCaption!![i].substring(0, commentCaption!![i].length-1))
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .dontAnimate()
                    .into(commentViewHolder.image)
            }
            else{
                commentViewHolder.author.text = commentAuthor[i]
                commentViewHolder.caption.visibility = View.GONE
                commentViewHolder.image.visibility = View.VISIBLE
                GlideApp.with(context)
                    .load(commentCaption!![i])
                    .placeholder(R.mipmap.refreshing)
                    .dontAnimate()
                    .into(commentViewHolder.image)
            }
        }
        else {
            commentViewHolder.caption.visibility = View.VISIBLE
            commentViewHolder.image.visibility = View.GONE
            commentViewHolder.author.text = commentAuthor[i]
            commentViewHolder.caption.text = commentCaption!![i]
        }
    }
}