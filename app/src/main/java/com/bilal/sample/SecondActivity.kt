package com.bilal.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.view.ViewCompat
import com.bilal.sample.ZoomActivity.Companion.TRANS_IMAGE
import com.bilal.sample.ZoomActivity.Companion.TRANS_TEXT
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ActivityCompat.startPostponedEnterTransition(this)

        ViewCompat.setTransitionName(expanded_image, TRANS_IMAGE)
        ViewCompat.setTransitionName(expanded_text_view, TRANS_TEXT)
    }
}
