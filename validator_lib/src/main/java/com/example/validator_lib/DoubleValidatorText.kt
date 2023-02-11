package com.example.validator_lib

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText

class DoubleValidatorText(context: Context, attrs: AttributeSet?) :
    AppCompatEditText(context, attrs) {

    val editText1 = findViewById<EditText>(R.id.password)
    val editText2 = findViewById<EditText>(R.id.re_password)

    fun setErrorMessage(msg: String) {
        setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            R.drawable.ic_round_error_24,
            0
        )
        error = msg
    }

    fun isNotEmpty(): Boolean {
        if (text!!.isEmpty()) {
            setErrorMessage("line is empty!")
        }
        return text!!.isNotEmpty()
    }

    fun ifBothIsSame() {
        if (editText1.text == editText2.text) {
            checkCorrectAndSetError()
        }else{
            setErrorMessage("Passwords are not the same!")
        }
    }

    fun checkCorrectAndSetError() {
        if (isNotEmpty()) {
            setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                0,
                0
            )
            setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.ic_round_check_circle_24,
                0
            )
        }

    }


}