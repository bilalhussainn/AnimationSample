package com.bilal.sample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Path
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.view.View
import com.bilal.sample.helper.AnimationHelper
import kotlinx.android.synthetic.main.activity_main.*
import com.bilal.sample.helper.AnimatorHelper


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

            }
        })

        //Your App ID:  08c48a31-0ba7-4e72-bd6c-201434a285c7
        otp_view.setOtp("132432")*/






        //Animation API

        //AnimationHelper.fadeIn(test_view)
        //AnimationHelper.fadeOut(test_view)
        //AnimationHelper.slideUp(this,true, test_view,test_view2)
        //AnimationHelper.scaleIn(this,true, test_view3,test_view4)
        //AnimationHelper.rotateAnimation(test_view)
        //AnimationHelper.animationFromResource(this,test_view)



        //Animator API

        //AnimatorHelper.objectAnimator(text_int)
        AnimatorHelper.valueAnimator(text_int)
        //AnimatorHelper.shake(text_int)
        //AnimatorHelper.multiplePropertyAnimator(text_int)
        //AnimatorHelper.resourcePropertyAnimation(this,text_int)
        //AnimatorHelper.resValueAnimator(this,text_int)





/*        Handler().postDelayed({
            startActivity(Intent(this,SecondActivity::class.java))
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right )


        },2000)*/


      /*  Handler().postDelayed({
        var intent = Intent(this,SecondActivity::class.java)
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        },2000)*/






        /*Handler().postDelayed({
            var intent = Intent(this,SecondActivity::class.java)
            startActivity(intent,
                    ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        },2000)*/

      //  crossfade()

    //    curvedPath()


    }


    val mShortAnimationDuration = 400

    private fun crossfade() {
        test_view.apply {
            // Set the content view to 0% opacity but visible, so that it is visible
            // (but fully transparent) during the animation.
            alpha = 0f
            visibility = View.VISIBLE

            // Animate the content view to 100% opacity, and clear any animation
            // listener set on the view.
            animate()
                    .alpha(1f)
                    .setDuration(mShortAnimationDuration.toLong())
                    .setListener(null)
        }
        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        text_int.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration.toLong())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        text_int.visibility = View.GONE
                    }
                })
    }


    fun curvedPath(){
        // arcTo() and PathInterpolator only available on API 21+
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val path = Path().apply {
                moveTo(0f,0f)
                arcTo(0f, 0f, 1000f, 1000f, 270f, -180f, true)
            }
            val pathInterpolator = PathInterpolator(path)


            val animation = ObjectAnimator.ofFloat(text_int, "translationX", 100f).apply {
                interpolator = pathInterpolator
                start()
            }
        }*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val path = Path().apply {
                lineTo(600f,300f)
             //   moveTo(600f,300f)
                arcTo(0f, 0f, 600f, 600f, 0f, -180f, true)
            }
            val animator = ObjectAnimator.ofFloat(text_int, View.X, View.Y, path).apply {
                duration = 2000
                start()
            }
        } else {
            // Create animator without using curved path
        }


    }


}
