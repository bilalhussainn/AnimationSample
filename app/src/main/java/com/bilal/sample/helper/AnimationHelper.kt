package com.bilal.sample.helper

import android.animation.*
import android.content.Context
import android.view.View
import android.view.animation.*
import com.bilal.sample.R
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.TextView
import android.view.View.*


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
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener {
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

    fun slideUp(context: Context, enableFade: Boolean, vararg view: View) {

        var animationSet = AnimationSet(true)

        //Translate Animation
        var translateAnimation = TranslateAnimation(0F, 0F,
                context.resources.getDimension(R.dimen.dimen_80_dp), 0F)
        translateAnimation.duration = 2500
        var easyInAnimation = AccelerateDecelerateInterpolator()
        translateAnimation.interpolator = easyInAnimation
        animationSet.addAnimation(translateAnimation)

        //Alpha Animation
        if (enableFade) {
            var alphaAnim: Animation = AlphaAnimation(0.0f, 1.0f)
            alphaAnim.duration = 500
            alphaAnim.interpolator = AccelerateDecelerateInterpolator()
            animationSet.addAnimation(alphaAnim)
        }

        for (item in view) {
            item.startAnimation(animationSet)
        }
    }

    fun scaleIn(context: Context, enableFade: Boolean, vararg view: View) {

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
        if (enableFade) {
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

    fun rotateAnimation(view: View) {

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
        scaleAnimation.repeatMode = Animation.REVERSE   //Animation.REVERSE
        scaleAnimation.repeatCount = 1
        scaleAnimation.startOffset = 500
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
        rotateAnimation.repeatCount = 1
        rotateAnimation.startOffset = 500
        //rotateAnimation.fillAfter = true


        animationSet.addAnimation(rotateAnimation)
        animationSet.fillAfter = true
        //    animationSet.fillBefore = true
        //animationSet.isFillEnabled = true

        view.startAnimation(animationSet)
    }

    fun objectAnimator(view: View) {

        var alpha = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        alpha.duration = 3000


        var scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 0.5f)
        var scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 0.5f)
        scaleDownX.duration = 3000
        scaleDownY.duration = 3000


        // ---- 1st Way ---- //
        //alpha.start()
        //scaleDownX.start()
        //scaleDownY.start()

        // ---- 2st Way ---- //
/*        var animatorSet1 = AnimatorSet()
        animatorSet1.play(alpha).with(scaleDownX).with(scaleDownY)
        animatorSet1.start()*/


        // ---- 3rd Way ---- //  //Parallel Animations
        /*var animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleDownX, scaleDownY, alpha)
        animatorSet.start()*/

        // ---- 4th Way ---- //  //Serial Animations
        /*var animatorSet3 = AnimatorSet()
        animatorSet3.playSequentially(scaleDownX, scaleDownY, alpha)
        animatorSet3.start()*/


    }

    fun valueAnimator(view: View) {
        ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 2000
            setTarget(view)
            addUpdateListener {
                view.alpha = it.animatedValue as Float
            }
            start()

        }
    }


    fun multiplePropertyAnimator(view: View) {

        val pvhX = PropertyValuesHolder.ofFloat(TRANSLATION_X, 450f)
        val pvhY = PropertyValuesHolder.ofFloat(TRANSLATION_Y, 450f)
        val scaleX = PropertyValuesHolder.ofFloat(SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(SCALE_Y, 2f)
        val rotateX = PropertyValuesHolder.ofFloat(ROTATION_X, 360f)
        val rotateY = PropertyValuesHolder.ofFloat(ROTATION_Y, 360f)
        val alpha = PropertyValuesHolder.ofFloat(ALPHA, 0.5f, 1f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, alpha, pvhX, pvhY, scaleX, scaleY, rotateX, rotateY)
        animator.duration = 1000 * 2
        animator.start()
    }

    fun resourcePropertyAnimation(context: Context, view: View) {

        (AnimatorInflater.loadAnimator(context, R.animator.set_x_y_alpha) as AnimatorSet).apply {
            setTarget(view)  //sets a single target object for all children of the AnimatorSet
            start()
        }
    }



    fun resValueAnimator(context: Context, view: View) {
        (AnimatorInflater.loadAnimator(context, R.animator.value_animator) as ValueAnimator).apply {

            addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAnimationCancel(animation: Animator?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onAnimationStart(animation: Animator?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })

            addUpdateListener { updatedAnimation ->
                view.translationX = updatedAnimation.animatedValue as Float
            }
            start()
        }
    }


/*    stream.addProperty("drawing:elevation", getElevation())
    stream.addProperty("drawing:translationX", getTranslationX())
    stream.addProperty("drawing:translationY", getTranslationY())
    stream.addProperty("drawing:translationZ", getTranslationZ())
    stream.addProperty("drawing:rotation", getRotation())
    stream.addProperty("drawing:rotationX", getRotationX())
    stream.addProperty("drawing:rotationY", getRotationY())
    stream.addProperty("drawing:scaleX", getScaleX())
    stream.addProperty("drawing:scaleY", getScaleY())
    stream.addProperty("drawing:pivotX", getPivotX())
    stream.addProperty("drawing:pivotY", getPivotY())
    stream.addProperty("drawing:clipBounds",
    if (mClipBounds == null) null else mClipBounds.toString())
    stream.addProperty("drawing:opaque", isOpaque())
    stream.addProperty("drawing:alpha", getAlpha())
    stream.addProperty("drawing:transitionAlpha", getTransitionAlpha())*/


}