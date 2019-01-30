package com.bilal.sample.helper

import android.animation.*
import android.content.Context
import android.view.View
import com.bilal.sample.R
import android.support.v4.view.ViewCompat.setTranslationX
import android.animation.ValueAnimator
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.PathInterpolator
import android.widget.TextView



object AnimatorHelper{  //Api Level 11


    fun objectAnimator(view: View) {

        var alpha = ObjectAnimator.ofFloat(view, "alpha", 1f,0.5f,1f)
        alpha.duration = 3000
        //alpha.startDelay =2000


        var scaleDownX = ObjectAnimator.ofFloat(view, "scaleX", 1f,0.5f,1f)
        var scaleDownY = ObjectAnimator.ofFloat(view, "scaleY", 1f,0.5f,1f)
        scaleDownX.duration = 3000
        scaleDownY.duration = 3000


        // ---- 1st Way ---- //
        //alpha.start()
       // scaleDownX.start()
      //  scaleDownY.start()

        // ---- 2st Way ---- //
        /*var animatorSet1 = AnimatorSet()
        animatorSet1.play(alpha).with(scaleDownX).with(scaleDownY)
        animatorSet1.start()*/


        // ---- 3rd Way ---- //  //Parallel Animations
       /* var animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleDownX, scaleDownY, alpha)
        animatorSet.start()*/

        // ---- 4th Way ---- //  //Serial Animations
        /*var animatorSet3 = AnimatorSet()
        animatorSet3.playSequentially(alpha,scaleDownX,scaleDownY)
        animatorSet3.start()*/


    }

    fun valueAnimator(view: View) {
        ValueAnimator.ofFloat(0f, 300f).apply {
            interpolator = BounceInterpolator()
            duration = 2000
            repeatMode= ValueAnimator.REVERSE
            repeatCount = 2
            setTarget(view)
            addUpdateListener {
                view.translationX = it.animatedValue as Float
            }
            start()
        }
    }

    fun shake(view: View) {
        val va = ValueAnimator.ofFloat(0f, 30f,0f,-30f,0f,30f,0f,-30f,0f) //pixel values
        va.duration = 800
        va.addUpdateListener { animation -> view.translationX = animation.animatedValue as Float }
        va.start()
    }


    fun multiplePropertyAnimator(view: View) {
        val translateX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, 450f)
        val translateY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 450f)
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)
        val rotateX = PropertyValuesHolder.ofFloat(View.ROTATION_X, 360f)
        val rotateY = PropertyValuesHolder.ofFloat(View.ROTATION_Y, 360f)
        val alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0.5f, 1f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(view, alpha, translateX,translateY,scaleX,scaleY, rotateX,rotateY)
        animator.duration = 1000 * 2
        animator.start()
    }


    //Not working
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
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
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