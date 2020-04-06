package com.an9ar.imgurgallery.activities

import android.os.Bundle
import com.an9ar.imgurgallery.R
import com.an9ar.imgurgallery.common.BaseMvpActivity

class MainActivity : BaseMvpActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}