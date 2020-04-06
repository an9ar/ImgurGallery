package com.an9ar.imgurgallery.adapters.comment

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.an9ar.imgurgallery.R

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
    var caption : TextView = itemView.findViewById(R.id.comment_caption)
    var author : TextView = itemView.findViewById(R.id.comment_author)
    var image : ImageView = itemView.findViewById(R.id.comment_image)
}