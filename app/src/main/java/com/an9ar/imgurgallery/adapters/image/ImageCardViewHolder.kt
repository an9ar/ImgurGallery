package com.an9ar.imgurgallery.adapters.image

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.an9ar.imgurgallery.R
import com.an9ar.imgurgallery.activities.SelectedImageActivity


class ImageCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var image: ImageView = itemView.findViewById(R.id.cardImage)
    var text: TextView = itemView.findViewById(R.id.cardText)
    lateinit var optionsCompat: ActivityOptions
    var IMAGE_URL: String? = null
    var id : String? = null

    private fun unwrap(ctx: Context): Activity {
        var context = ctx
        while (context !is Activity && context is ContextWrapper) {
            context = context.baseContext
        }
        return context as Activity
    }

    init {
        itemView.setOnClickListener { v ->
            val viewContext = unwrap(v.context)
            val intent = Intent(viewContext, SelectedImageActivity::class.java)
            intent.putExtra("image", IMAGE_URL)
            intent.putExtra("text", text.text.toString())
            intent.putExtra("id", id)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                optionsCompat = ActivityOptions.makeSceneTransitionAnimation(viewContext, image, viewContext.getString(R.string.transition_name))
            }
            ActivityCompat.startActivity(viewContext, intent, optionsCompat.toBundle())
        }

    }
}