package com.bilal.sample

import android.app.ActivityOptions
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bilal.sample.ui.OtpView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.provider.MediaStore
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Matrix
import android.os.Handler
import com.bilal.sample.helper.AnimationHelper


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* left.setOnClickListener { custom_view.setLandscapeLeft() }
        right.setOnClickListener { custom_view.setLandscapeRight() }
        top.setOnClickListener { custom_view.setPortraitTop() }
        bottom.setOnClickListener { custom_view.setPortraitBottom() }
        full.setOnClickListener { custom_view.setFullScreen() }

        otp_view.setListener(object : OtpView.OtpEventListener{
            override fun onCompleteOtpEntered() {
                //call api in presenter.

            }
        })

        otp_view.setOtp("132432")*/


        //Your App ID:  08c48a31-0ba7-4e72-bd6c-201434a285c7


    //    AnimationHelper.fadeIn(test_view)
    //    AnimationHelper.slideUp(this,true, test_view,test_view2)
    //    AnimationHelper.scaleIn(this,true, test_view3,test_view4)







/*        Handler().postDelayed({
            startActivity(Intent(this,SecondActivity::class.java))
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right )


        },2000)*/

/*

        Handler().postDelayed({
        var intent = Intent(this,SecondActivity::class.java)
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        },2000)
*/

        AnimationHelper.rotateAnimation(test_view)


        AnimationHelper.objectAnimator(text_int)


    }




}
