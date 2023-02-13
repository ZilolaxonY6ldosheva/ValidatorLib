package com.example.createownlibrary


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isNotEmpty
import com.example.createownlibrary.databinding.ActivityMainBinding
import com.example.validator_lib.DoubleValidatorText
import com.example.validator_lib.R
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpSpinner()
        setListeners()

    }

    private fun setUpSpinner() {
        val values: Array<String> =
            arrayOf("England", "Russia", "Italy", "Uzbekistan", "Argentina", "Bolivia")
        values.sort()

        val adapter = ArrayAdapter(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, values)
        binding.validatorSpinner.setAdapter(adapter)
    }


    private fun setListeners() {
        binding.apply {
            clearBtn.setOnClickListener {
                validatorSpinner.isSelected(false)
                emailEt.text?.clear()
                firstEt.text?.clear()
                phoneEt.text?.clear()
                ipaddressEt.text?.clear()
                yearEt.text?.clear()
                descEt.text?.clear()
                doublePasswordEt.clear()
                doubleEt.clear()
            }
            submitBtn.setOnClickListener {
                checkData()
                if (dataFull())
                    Toast.makeText(this@MainActivity, "Data Full", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun dataFull(): Boolean {
        binding.apply {

            return (isFull() && validatorSpinner.isItemSelected()
                    && doubleEt.isNotEmpty())
        }
    }

    fun isFull(): Boolean {
        binding.apply {
            return (firstEt.isNotEmpty() && emailEt.isNotEmpty() && phoneEt.isNotEmpty() && ipaddressEt.isNotEmpty() &&
                    descEt.isNotEmpty() && yearEt.isNotEmpty())
        }
    }


    private fun checkData() {
        binding.apply {
            doubleEt.checkTextAndSetError()
            doublePasswordEt.checkTextAndSetError()
            firstEt.checkCorrectAndSetError()
            emailEt.checkCorrectAndSetError()
            phoneEt.checkCorrectAndSetError()
            ipaddressEt.checkCorrectAndSetError()
            descEt.checkCorrectAndSetError()
            yearEt.checkCorrectAndSetError()
            validatorSpinner.isItemSelected() }
    }

}
