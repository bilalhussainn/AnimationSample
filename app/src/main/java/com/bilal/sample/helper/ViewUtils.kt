package com.nurvv.app.utilities

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.VectorDrawable
import android.os.Build
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.widget.TextView
import android.view.animation.AlphaAnimation

/**
 * @author Filippo
 * @version 1.0.0
 * @since Wed, 24/10/2018 at 18:52.
 */
object ViewUtils {

    private const val SHORT_ANIMATION_DURATION : Long = 200

    @JvmStatic
    fun gone(vararg views: View) {
        for (view in views) {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    fun visible(vararg views: View) {
        for (view in views) {
            view.visibility = View.VISIBLE
        }
    }

    @JvmStatic
    fun invisible(vararg views: View) {
        for (view in views) {
            view.visibility = View.INVISIBLE
        }
    }

    @JvmStatic
    fun setVisible(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    fun setVisibleGone(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    fun setGone(view: View, gone: Boolean) {
        view.visibility = if (gone) View.GONE else View.VISIBLE
    }

    fun revealView(view: View, duration: Long) {
        revealView(view, view.width, view.height, duration)
    }

    fun revealView(view: View, width: Int, height: Int, duration: Long) {

        val finalRadius = (Math.max(width, height) * 1.1).toFloat()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val circularReveal = ViewAnimationUtils.createCircularReveal(view, width / 2, height / 2, 0f, finalRadius)
            circularReveal.duration = duration
            circularReveal.interpolator = AccelerateInterpolator()
            view.visibility = View.VISIBLE
            circularReveal.start()
        } else {
            view.visibility = View.VISIBLE
        }
    }

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

    @JvmStatic
    fun dpToPx(context: Context, value: Float): Int {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.resources.displayMetrics))
    }

    @JvmStatic
    fun spToPx(context: Context, spValue: Float): Int {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.resources.displayMetrics))
    }

    @JvmStatic
    fun setTextToView(text: String, vararg views: TextView){
        for (view in views) {
            view.text = text
        }
    }

    @JvmStatic
    fun applyScaleAnimationOnTouch(view: View?) {
        view?.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    v?.animate()?.scaleX(0.9f)?.setDuration(100)?.start()
                    v?.animate()?.scaleY(0.9f)?.setDuration(100)?.start()
                }
                MotionEvent.ACTION_UP -> {
                    v?.animate()?.scaleX(1.0f)?.setDuration(100)?.start()
                    v?.animate()?.scaleY(1.0f)?.setDuration(100)?.start()
                }
            }
            return@OnTouchListener false
        })
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    fun getBitmap(context: Context, drawableId: Int): Bitmap {
        val drawable = ContextCompat.getDrawable(context, drawableId)
        return when (drawable) {
            is BitmapDrawable -> drawable.bitmap
            is VectorDrawable -> getBitmap((drawable as VectorDrawable?)!!)
            else -> throw IllegalArgumentException("unsupported drawable type")
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    fun getScaledBitmap(context: Context, drawableId: Int, width: Int, height: Int): Bitmap {
        val drawable = ContextCompat.getDrawable(context, drawableId)
        return Bitmap.createScaledBitmap(when (drawable) {
            is BitmapDrawable -> drawable.bitmap
            is VectorDrawable -> getBitmap((drawable as VectorDrawable?)!!)
            else -> throw IllegalArgumentException("unsupported drawable type")
        }, width, height, true)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @JvmStatic
    fun getBitmap(vectorDrawable: VectorDrawable): Bitmap {
        val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth,
                vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        return bitmap
    }
}
