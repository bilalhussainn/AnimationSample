package com.bilal.sample.helper

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.animation.*
import com.bilal.sample.R
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.TextView

object AnimationHelper {

    const val SHORT_ANIMATION_DURATION = 200L
    const val LONG_ANIMATION_DURATION = 400L

    fun fadeIn(vararg view: View) {
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        alphaAnimation.duration = SHORT_ANIMATION_DURATION
        for (item in view) {
            item.visibility = View.VISIBLE
            item.startAnimation(alphaAnimation)
        }
    }

    fun fadeOut(vararg view: View) {
        val alphaAnimation = AlphaAnimation(1.0f, 0.0f)
        alphaAnimation.duration = SHORT_ANIMATION_DURATION
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                for (item in view) {
                    item.visibility = View.INVISIBLE
                }
            }
            override fun onAnimationStart(p0: Animation?) {}
        })
        for (item in view) {
            item.startAnimation(alphaAnimation)
        }
    }

    fun slideUp(context: Context, enableFade : Boolean,vararg view: View) {

        var animationSet = AnimationSet(true)

        //Translate Animation
        var translateAnimation = TranslateAnimation(0F, 0F,
                context.resources.getDimension(R.dimen.dimen_80_dp), 0F)
        translateAnimation.duration = 2500
        var easyInAnimation = AccelerateDecelerateInterpolator()
        translateAnimation.interpolator = easyInAnimation
        animationSet.addAnimation(translateAnimation)

        //Alpha Animation
        if(enableFade) {
            var alphaAnim: Animation = AlphaAnimation(0.0f, 1.0f)
            alphaAnim.duration = 500
            alphaAnim.interpolator = AccelerateDecelerateInterpolator()
            animationSet.addAnimation(alphaAnim)
        }

        for (item in view) {
            item.startAnimation(animationSet)
        }
    }

    fun scaleIn(context: Context, enableFade : Boolean, vararg view: View) {

        var startScale = 3f
        var endScale = 1f

        var animationSet = AnimationSet(true)

        //Translate Animation
        val scaleAnimation = ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, .5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, .5f) // Pivot point of Y scaling
        scaleAnimation.duration = 2500
        var easyInAnimation = AccelerateDecelerateInterpolator()
        scaleAnimation.interpolator = easyInAnimation
        animationSet.addAnimation(scaleAnimation)

        //Alpha Animation
        if(enableFade) {
            var alphaAnim: Animation = AlphaAnimation(0.0f, 1.0f)
            alphaAnim.duration = 500
            alphaAnim.interpolator = AccelerateDecelerateInterpolator()
            animationSet.addAnimation(alphaAnim)
        }

        for (item in view) {
            item.startAnimation(animationSet)
        }
    }


    fun scaleView(v: View, startScale: Float, endScale: Float) {
        val anim = ScaleAnimation(
                1f, 1f, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f) // Pivot point of Y scaling
        anim.fillAfter = true // Needed to keep the result of the animation
        anim.duration = 1000
        v.startAnimation(anim)
    }

    fun rotateAnimation(view : View){

        var startScale = 3f
        var endScale = 1f

        var animationSet = AnimationSet(true)

        //Translate Animation
        val scaleAnimation = ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, .5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, .5f) // Pivot point of Y scaling
        scaleAnimation.duration = 1000
        scaleAnimation.repeatMode =  Animation.REVERSE   //Animation.REVERSE
        scaleAnimation.repeatCount = 1
        scaleAnimation.startOffset = 500
        //scaleAnimation.fillAfter = true
        var easyInAnimation = AccelerateDecelerateInterpolator()
        scaleAnimation.interpolator = easyInAnimation
        animationSet.addAnimation(scaleAnimation)

        val rotateAnimation = RotateAnimation(0f,360f,
                Animation.RELATIVE_TO_SELF,.5f,
                Animation.RELATIVE_TO_SELF,.5f)
        rotateAnimation.duration = 1000
        rotateAnimation.interpolator = AccelerateDecelerateInterpolator()
        rotateAnimation.repeatMode =  Animation.REVERSE   //Animation.REVERSE
        rotateAnimation.repeatCount = 1
        rotateAnimation.startOffset = 500
        //rotateAnimation.fillAfter = true



        animationSet.addAnimation(rotateAnimation)
        animationSet.fillAfter = true
        //    animationSet.fillBefore = true
        //animationSet.isFillEnabled = true

        view.startAnimation(animationSet)
    }

    fun objectAnimator(view : View){

        var objectAnimator = ObjectAnimator.ofFloat(view,"alpha",0f,1f).apply {
            duration =5000


            addListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAnimationCancel(animation: Animator?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAnimationStart(animation: Animator?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAnimationEnd(animation: Animator?) {

                }

            })
        }

        objectAnimator.start()

    }

}