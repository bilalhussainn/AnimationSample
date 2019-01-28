package com.bilal.sample.ui

import android.content.Context
import android.graphics.Bitmap
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import com.bilal.sample.R

class CustomView : ConstraintLayout {
    @JvmOverloads
    constructor(
            context: Context,
            attrs: AttributeSet? = null,
            defStyleAttr: Int = 0)
            : super(context, attrs, defStyleAttr)

    private var imageView: ImageView
    private var parent: ConstraintLayout
    private var mConstraintSet: ConstraintSet
    //
    private var mHalfHeight : Int = 0
        get() { return (height / 2) }
    private var mHalfWidth : Int = 0
        get() { return (width / 2) }

    private fun getHalfWidth() = width / 2
    private fun getHalfHeight() = height / 2

    init {
        var view = LayoutInflater.from(context).inflate(R.layout.layout_view, this, true)
        imageView = view.findViewById(R.id.image_view)
        parent = view.findViewById(R.id.parent)
        mConstraintSet = ConstraintSet()
    }

    fun setPortraitTop() {
        parent.layoutParams.width = width
        parent.layoutParams.height = getHalfHeight()

        mConstraintSet.clone(this)
        mConstraintSet.clear(R.id.parent, ConstraintSet.BOTTOM)
        mConstraintSet.connect(R.id.parent, ConstraintSet.TOP,
                id, ConstraintSet.TOP, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.LEFT,
                id, ConstraintSet.LEFT, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.RIGHT,
                id, ConstraintSet.RIGHT, 0)
        mConstraintSet.applyTo(this)
    }

    fun setPortraitBottom() {
        parent.layoutParams.width = width
        parent.layoutParams.height = getHalfHeight()

        mConstraintSet.clone(this)
        mConstraintSet.clear(R.id.parent, ConstraintSet.TOP)
        mConstraintSet.connect(R.id.parent, ConstraintSet.BOTTOM,
                id, ConstraintSet.BOTTOM, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.LEFT,
                id, ConstraintSet.LEFT, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.RIGHT,
                id, ConstraintSet.RIGHT, 0)
        mConstraintSet.applyTo(this)
    }

    fun setLandscapeLeft() {
        parent.layoutParams.width = getHalfWidth()
        parent.layoutParams.height = height

        mConstraintSet.clone(this)
        mConstraintSet.clear(R.id.parent, ConstraintSet.RIGHT)
        mConstraintSet.connect(R.id.parent, ConstraintSet.LEFT,
                id, ConstraintSet.LEFT, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.TOP,
                id, ConstraintSet.TOP, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.BOTTOM,
                id, ConstraintSet.BOTTOM, 0)
        mConstraintSet.applyTo(this)
    }

    fun setLandscapeRight() {
        parent.layoutParams.width = getHalfWidth()
        parent.layoutParams.height = height

        mConstraintSet.clone(this)
        mConstraintSet.clear(R.id.parent, ConstraintSet.LEFT)
        mConstraintSet.connect(R.id.parent, ConstraintSet.RIGHT,
                id, ConstraintSet.RIGHT, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.TOP,
                id, ConstraintSet.TOP, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.BOTTOM,
                id, ConstraintSet.BOTTOM, 0)
        mConstraintSet.applyTo(this)
    }

    fun setFullScreen() {
        parent.layoutParams.width = width
        parent.layoutParams.height = height

        mConstraintSet.clone(parent)
        mConstraintSet.connect(R.id.parent, ConstraintSet.LEFT,
                id, ConstraintSet.LEFT, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.TOP,
                id, ConstraintSet.TOP, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.BOTTOM,
                id, ConstraintSet.BOTTOM, 0)
        mConstraintSet.connect(R.id.parent, ConstraintSet.RIGHT,
                id, ConstraintSet.RIGHT, 0)
        mConstraintSet.applyTo(parent)
    }

    fun setImageResource(drawable: Int) {
        imageView.setImageResource(drawable)
    }

    fun setImageBitmap(bitmap: Bitmap) {
        imageView.setImageBitmap(bitmap)
    }

}