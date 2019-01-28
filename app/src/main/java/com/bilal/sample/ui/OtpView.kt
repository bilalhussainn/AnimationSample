package com.bilal.sample.ui

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.view.ContextThemeWrapper
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.LayoutInflater
import com.bilal.sample.R
import kotlinx.android.synthetic.main.layout_otp_view.view.*
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener

class OtpView
@JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


  //  private var listener: OtpEventListener? = null
    private var count: Int

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_otp_view, this, true)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.OtpView, defStyleAttr, 0)
        count = typedArray.getInt(R.styleable.OtpView_count, 4)
        typedArray.recycle()
        createViews()
  //      initEvents()
    }

    private fun createViews() {

        var inputList = ArrayList<EditText>()
        for (pos in 1..count) {
            var editText = EditText(ContextThemeWrapper(context, R.style.OtpTheme), null, 0)
            editText.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            editText.setText("Hello", TextView.BufferType.EDITABLE)
            editText.isCursorVisible = true
            editText.isFocusable = true
            editText.isFocusableInTouchMode = true
            inputList.add(editText)
            addView(editText)
        }

        //adding Constraints
        for(index in inputList){

        }

    }

    /*var density = context.resources.displayMetrics.density
    var px = someDpValue * density
    var dp = somePxValue / density*/

    fun dpToPx(dp:Int) =  dp * context.resources.displayMetrics.density

  /*  private fun initEvents() {
        input1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (input1.text?.isNotEmpty()!!)
                    input2.requestFocus()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                *//*if(input1.text.isNotEmpty())
                    input1.text.clear()*//*
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        input2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (input2.text?.isNotEmpty()!!)
                    input3.requestFocus()
                *//*else if(input2.text.isEmpty())
                    input1.requestFocus()*//*
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        input3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (input3.text?.isNotEmpty()!!)
                    input4.requestFocus()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        input4.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (input4.text?.isNotEmpty()!!)
                    input5.requestFocus()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        input5.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if(input5.text?.isNotEmpty()!!)
                    input6.requestFocus()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        input6.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (input6.text?.isNotEmpty()!!)
                    listener?.onCompleteOtpEntered()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        //Handler().postDelayed({initKeyEvents()},1000)


        input6.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId and EditorInfo.IME_MASK_ACTION == EditorInfo.IME_ACTION_DONE) {
                //do something here.
                true
            } else false
        })
    }

    fun initKeyEvents(){
        input6.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if(input6.text?.isEmpty()!!)
                    input5.requestFocus()
            }
            false}
    }

    fun setListener(callback: OtpEventListener) {
        listener = callback
    }

    interface OtpEventListener {
        fun onCompleteOtpEntered()
    }

    fun setOtp(otpValue : String){
        otpValue?.run {
            if(otpValue.length >=6) {
                input1.setText(otpValue.substring(0,1))
                input2.setText(otpValue.substring(1,2))
                input3.setText(otpValue.substring(2,3))
                input4.setText(otpValue.substring(3,4))
                input5.setText(otpValue.substring(4,5))
                input6.setText(otpValue.substring(5,6))
                input6.requestFocus()
            }
        }
    }
*/
}