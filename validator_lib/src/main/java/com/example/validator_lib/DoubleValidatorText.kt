package com.example.validator_lib

import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import kotlinx.android.synthetic.main.double_edit_txt.view.*

class DoubleValidatorText(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {


//    var text: String? = null

    init {
        val atributes: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.ValidatorEditText)
        inflate(context, R.layout.double_edit_txt, this)
        orientation = HORIZONTAL

//        text = atributes.getString(R.styleable.ValidatorEditText_text1)
        atributes.recycle()
    }

    fun setError(switch: Int) {
        when (switch) {
            2 -> {
                re_password_img.setImageResource(R.drawable.ic_round_error_24)
                password_img.setImageResource(R.drawable.ic_round_error_24)
            }
            1 -> {
                re_password_img.setImageResource(R.drawable.ic_round_error_24)

            }
            0 -> {
                password_img.setImageResource(R.drawable.ic_round_error_24)

            }
        }


    }


    fun isNotEmpty(): Boolean {
        if (re_password.text.isEmpty() && password.text.isEmpty()) {
            setError(2)
        } else if (re_password.text.isEmpty() && password.text.isNotEmpty()) {
            setError(1)
        } else if (re_password.text.isNotEmpty() && password.text.isEmpty()) {
            setError(0)
        }
        return re_password.text!!.isNotEmpty() && password.text!!.isNotEmpty()
    }


    fun setTextListeners() {
        re_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkBothAndSetDrawable(s == password.text)
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    fun checkBothAndSetDrawable(same: Boolean) {
        if (same) {
            re_password_img.setImageResource(R.drawable.ic_round_check_circle_24)

        } else {
            re_password_img.setImageResource(R.drawable.ic_round_error_24)

        }
    }
}