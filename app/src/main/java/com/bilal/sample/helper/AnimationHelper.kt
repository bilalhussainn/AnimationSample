package com.bilal.sample.helper

import android.content.Context
import android.view.View
import android.view.animation.*
import com.bilal.sample.R
import android.view.animation.Animation
import android.view.animation.ScaleAnimation


object AnimationHelper {  //Api Level 1

    const val SHORT_ANIMATION_DURATION = 200L
    const val LONG_ANIMATION_DURATION = 400L

    //Single Animation
    fun fadeIn(vararg view: View) {
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        alphaAnimation.duration = 2000
        for (item in view) {
            item.visibility = View.VISIBLE
            item.startAnimation(alphaAnimation)
        }
    }

    //Single Animation
    fun fadeOut(vararg view: View) {
        val alphaAnimation = AlphaAnimation(1.0f, 0.0f)
        alphaAnimation.duration = 1000
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
               /* for (item in view) {
                    item.visibility = View.INVISIBLE
                }*/
            }

            override fun onAnimationStart(p0: Animation?) {}
        })
        for (item in view) {
            item.startAnimation(alphaAnimation)
        }
    }

    //Animation Set with Interpolator
    fun slideUp(context: Context, enableFade: Boolean, vararg view: View) {

        var animationSet = AnimationSet(false)
    //    animationSet.interpolator = AccelerateInterpolator()
        animationSet.interpolator = AnticipateInterpolator()
    //    animationSet.interpolator = DecelerateInterpolator()
    //    animationSet.interpolator = AccelerateDecelerateInterpolator()
    //    animationSet.interpolator = BounceInterpolator()
     //   animationSet.interpolator = CycleInterpolator(1.0f)
   //     animationSet.interpolator = OvershootInterpolator()

        //Translate Animation
        var translateAnimation = TranslateAnimation(0F, 0F,
                context.resources.getDimension(R.dimen.dimen_80_dp), 0F)
        translateAnimation.duration = 1000
        var easyInAnimation = AccelerateDecelerateInterpolator()
        translateAnimation.interpolator = easyInAnimation
        animationSet.addAnimation(translateAnimation)

        //Alpha Animation
        if (enableFade) {
            var alphaAnim: Animation = AlphaAnimation(0.0f, 1.0f)
            alphaAnim.duration = 1000
            alphaAnim.interpolator = BounceInterpolator()
            animationSet.addAnimation(alphaAnim)
        }

        for (item in view) {
            item.startAnimation(animationSet)
        }
    }

    fun scaleIn(context: Context, enableFade: Boolean, vararg view: View) {

        var startScale = 3f
        var endScale = 1f

        var animationSet = AnimationSet(false)

        //Translate Animation
        val scaleAnimation = ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
            //    Animation.RELATIVE_TO_SELF,
                .5f, // Pivot point of X scaling
            //    Animation.RELATIVE_TO_SELF,
                .5f) // Pivot point of Y scaling
        scaleAnimation.duration = 2500
        var easyInAnimation = OvershootInterpolator()
        scaleAnimation.interpolator = easyInAnimation
        animationSet.addAnimation(scaleAnimation)

        //Alpha Animation
        if (enableFade) {
            var alphaAnim: Animation = AlphaAnimation(0.0f, 1.0f)
            alphaAnim.duration = 1000
            alphaAnim.interpolator = AccelerateDecelerateInterpolator()
            animationSet.addAnimation(alphaAnim)
        }

        for (item in view) {
            item.startAnimation(animationSet)
        }
    }

    fun rotateAnimation(view: View) {

        var startScale = 3f
        var endScale = 1f

        var animationSet = AnimationSet(false)

        //Translate Animation
        val scaleAnimation = ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, .5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, .5f) // Pivot point of Y scaling
        scaleAnimation.duration = 1000
        scaleAnimation.repeatMode = Animation.REVERSE   //Animation.RESTART, Animation.REVERSE
        scaleAnimation.repeatCount = 0
        scaleAnimation.startOffset = 0
        //scaleAnimation.fillAfter = true
        var easyInAnimation = AccelerateDecelerateInterpolator()
        scaleAnimation.interpolator = easyInAnimation
        animationSet.addAnimation(scaleAnimation)

        val rotateAnimation = RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, .5f,
                Animation.RELATIVE_TO_SELF, .5f)
        rotateAnimation.duration = 1000
        rotateAnimation.interpolator = AccelerateDecelerateInterpolator()
        rotateAnimation.repeatMode = Animation.REVERSE   //Animation.REVERSE
        rotateAnimation.repeatCount = Animation.INFINITE
        rotateAnimation.startOffset = 1000
        //rotateAnimation.fillAfter = true

        animationSet.addAnimation(rotateAnimation)
        animationSet.fillAfter = true
        //    animationSet.fillBefore = true
        //animationSet.isFillEnabled = true

        view.startAnimation(animationSet)
    }

    fun animationFromResource(context: Context,view : View){
        val animShake: Animation = AnimationUtils.loadAnimation(context, R.anim.anim_rotate_alpha)
        view.startAnimation(animShake)
    }

    //Remaining

    //  animationSet.isFillEnabled = true



}