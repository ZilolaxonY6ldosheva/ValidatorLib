package com.example.validator_lib

import android.content.Context
import android.content.res.TypedArray
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText


class ValidatorEditText(context: Context, attrs: AttributeSet?) :
    AppCompatEditText(context, attrs) {

    private var atributes: TypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.ValidatorEditText)
    private val format: Int = atributes.getInt(R.styleable.ValidatorEditText_format, 0)

    init {
        setFormat(format)
    }

    private fun setHint(hint1: String) {
        hint = hint1
    }

    private fun setFormat(format: Int) {
        when (format) {
            0 -> {
                inputType = InputType.TYPE_CLASS_TEXT
            }
            1 -> {
                inputType = InputType.TYPE_TEXT_VARIATION_PHONETIC
            }
            2 -> {
                inputType = InputType.TYPE_CLASS_NUMBER
                keyListener = DigitsKeyListener.getInstance("0123456789.")
            }
            3 -> {
                inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                transformationMethod = PasswordTransformationMethod.getInstance()
            }
            4 -> {
                inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            }

        }
    }

    fun setErrorMessage(msg: String) {
        setCompoundDrawablesWithIntrinsicBounds(
            0,
            0,
            R.drawable.ic_round_error_24,
            0
        )
        error = msg
    }

    fun isCorrectFilled(): Boolean {
        var checker = false
        when (format) {
            0 -> {
                if (text.toString().isNotEmpty())
                    checker = true
            }
            1 -> {
                val phonePattern = "\\+[0-9]+".toRegex()
                checker = text.toString().matches(phonePattern)
            }
            2 -> {
                val ipPattern = "[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+".toRegex()
                checker = text.toString().matches(ipPattern)
            }
            3 -> {
                if (text.toString().isNotEmpty())
                    checker = true
            }
            4 -> {
                val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
                checker = text.toString().matches(emailPattern)
            }
        }
        return checker
    }

    fun isNotEmpty(): Boolean {
        if (text!!.isEmpty()) {
            setErrorMessage("line is empty!")
        }
        return text!!.isNotEmpty()
    }

    fun checkCorrectAndSetError() {
        if (isNotEmpty()) {
            if (!isCorrectFilled()) {
                setErrorMessage("format not correctly!")
            } else {
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


}