package com.example.validator_lib

import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import kotlinx.android.synthetic.main.double_edit_txt.view.*

class DoubleValidatorText(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {


    var atributes: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.StyleInputEditText)
    val format: Int = atributes.getInt(R.styleable.ValidatorEditText_format, 0)

    init {

        LayoutInflater.from(context).inflate(R.layout.double_edit_txt, this, true)
        orientation = HORIZONTAL

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


    fun setTextListeners() {
        re_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkBothAndSetDrawable(s.toString() == password.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

    fun clear() {

        re_password.text.clear()
        password.text.clear()
    }

    fun checkBothAndSetDrawable(same: Boolean) {
        if (same) {
            re_password_img.setImageResource(R.drawable.ic_round_check_circle_24)
        } else {
            re_password_img.setImageResource(R.drawable.ic_round_error_24)

        }
    }
}