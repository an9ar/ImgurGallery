package com.an9ar.imgurgallery.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.an9ar.imgurgallery.R
import com.an9ar.imgurgallery.adapters.comment.CommentListAdapter
import com.an9ar.imgurgallery.common.BaseMvpActivity
import com.an9ar.imgurgallery.presenters.SelectedImagePresenter
import com.an9ar.imgurgallery.views.SelectedImageView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_selected_image.*
import java.util.*

class SelectedImageActivity : BaseMvpActivity(), SelectedImageView {

    @InjectPresenter
    lateinit var presenter: SelectedImagePresenter

    @ProvidePresenter
    internal fun providePresenter(): SelectedImagePresenter =
        SelectedImagePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_selected_image)
        getExtra()
        initUI()
        presenter.getComments()
    }

    private fun initUI() {
        Glide.with(this)
            .load(presenter.imageURL)
            .placeholder(R.mipmap.refreshing)
            .error(R.drawable.ic_launcher_background)
            .dontAnimate()
            .dontTransform()
            .into(selectedImagePicture)
        selectedImageText.text = presenter.imageTitle
    }

    private fun getExtra(){
        val imageURL = intent?.getStringExtra("image")
        val imageTitle = intent?.getStringExtra("text")
        val imageID = intent?.getStringExtra("id")
        if (imageURL != null && imageTitle != null && imageID != null) {
            presenter.getCardInfo(imageURL, imageTitle, imageID)
        }
    }

    override fun initCommentRV(commentCaption: ArrayList<String>, commentAuthor: ArrayList<String>) {
        val linearLayoutManager  = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = CommentListAdapter(this, commentCaption, commentAuthor)
        rv_comments.layoutManager = linearLayoutManager
        rv_comments.adapter = adapter
    }

}
