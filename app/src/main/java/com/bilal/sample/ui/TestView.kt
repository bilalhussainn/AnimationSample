package com.bilal.sample.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import com.bilal.sample.R

class
TestView
@JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr) {

    var bgColor : Int = 0

    init {
        val attr = context.obtainStyledAttributes(attrs, R.styleable.TestView, 0, 0)
        attr?.let {
            try {
                bgColor = it.getColor(R.styleable.TestView_bgColor, ContextCompat.getColor(context,R.color.material_blue_grey_800))

            } finally {
                attr.recycle()
            }
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var paint = Paint()
        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        //paint.strokeWidth = ViewUtils.dpToPx(context,20f).toFloat()
        paint.strokeWidth = 50f
        paint.strokeCap = Paint.Cap.ROUND
        //paint.jo

        canvas?.drawLine(0f, (height / 2f), width.toFloat(), (height / 2f), paint)
        //  canvas?.drawCircle()

        var path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(width / 2f, height.toFloat())
        path.lineTo(width.toFloat(), 0f)
        //path.close()

        canvas?.drawPath(path, paint)



       /* override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)*/

        /*    var paint = Paint()
            paint.color = Color.BLACK
            paint.isAntiAlias = true
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = ViewUtils.dpToPx(context,20f).toFloat()
            paint.strokeCap = Paint.Cap.ROUND
            //paint.jo

            canvas?.drawLine()
            canvas?.drawCircle()*/


        //}

    }


}