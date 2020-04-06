package com.an9ar.imgurgallery.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.an9ar.imgurgallery.R
import com.an9ar.imgurgallery.adapters.image.ImageListAdapter
import com.an9ar.imgurgallery.adapters.image.ItemViewModel
import com.an9ar.imgurgallery.common.BaseFragment
import com.an9ar.imgurgallery.models.Image
import com.an9ar.imgurgallery.presenters.ImageListPresenter
import com.an9ar.imgurgallery.views.ImageListView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.view_image_list.*
import java.util.*

class ImageListFragment : BaseFragment(), ImageListView {

    @InjectPresenter
    lateinit var presenter: ImageListPresenter

    @ProvidePresenter
    internal fun providePresenter(): ImageListPresenter =
        ImageListPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.view_image_list, container, false)
        presenter.getList()
        return view
    }

    override fun initRV(imageUrl:ArrayList<String>, imageText:ArrayList<String>) {

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val itemViewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        val adapter = ImageListAdapter(context!!, imageUrl, imageText)
        itemViewModel.itemPagedList.observe(this,
            Observer<PagedList<Image>> { items ->
                rv_main.visibility = View.VISIBLE
                adapter.submitList(items)
            })
        rv_main.layoutManager = staggeredGridLayoutManager
        rv_main.adapter = adapter
    }

}
