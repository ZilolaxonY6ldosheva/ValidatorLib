package com.example.createownlibrary


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
//        setUpSpinner()
        setListeners()
    }

//    private fun setUpSpinner() {
//        val values: Array<String> =
//            arrayOf("England", "Russia", "Italy", "Uzbekistan", "Argentina", "Bolivia")
//        values.sort()
//
//        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, values)
//        binding.validatorSpinner.setAdapter(adapter)
//    }


    private fun setListeners() {
        binding.apply {
            clear.setOnClickListener {
//                validatorSpinner.isSelected(false)
                email.text?.clear()
                userId.text?.clear()
                telephone.text?.clear()
                ipAdress.text?.clear()
                year.text?.clear()
//                password.text.clear()
            }
            submit.setOnClickListener {
                checkData()
                if (dataFull())
                    Toast.makeText(this@MainActivity, "Data Full", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun dataFull(): Boolean {
        binding.apply {

            return (isFull()
                    && password11.isNotEmpty())
        }
    }

    //
    fun isFull(): Boolean {
        binding.apply {
            return (userId.isNotEmpty() && email.isNotEmpty() && telephone.isNotEmpty() && ipAdress.isNotEmpty()
                    && year.isNotEmpty())
        }
    }


    private fun checkData() {
        binding.apply {
            password11.setTextListeners()
            password11.isNotEmpty()
            userId.checkCorrectAndSetError()
            email.checkCorrectAndSetError()
            telephone.checkCorrectAndSetError()
            ipAdress.checkCorrectAndSetError()
            year.checkCorrectAndSetError()
        }
    }
}

