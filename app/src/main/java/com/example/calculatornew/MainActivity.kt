package com.example.calculatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatornew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var firstValue: String = ""
    private var input: String = ""
    private var sign: String = ""
    private var answer: Double = 0.0
    private var presDot: Boolean=false
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListeners()
        signBtnClick()
        equalBtnClick()
    }
    private fun setListeners() {
        binding.btn0.setOnClickListener {
            input += "0"
            setInput()
        }
        binding.btn1.setOnClickListener {
            input += "1"
            setInput()
        }
        binding.btn2.setOnClickListener {
            input += "2"
            setInput()
        }
        binding.btn3.setOnClickListener {
            input += "3"
            setInput()
        }
        binding.btn4.setOnClickListener {
            input += "4"
            setInput()
        }
        binding.btn5.setOnClickListener {
            input += "5"
            setInput()
        }
        binding.btn6.setOnClickListener {
            input += "6"
            setInput()
        }
        binding.btn7.setOnClickListener {
            input += "7"
            setInput()
        }
        binding.btn8.setOnClickListener {
            input += "8"
            setInput()
        }
        binding.btn9.setOnClickListener {
            input += "9"
            setInput()
        }
        binding.dotBtn.setOnClickListener {
            if (!input.isNullOrBlank() && presDot!=true){
            input += "."
                presDot=true
            setInput()
            }
        }

        binding.cleanBtn.setOnClickListener {
            firstValue = ""
            input = ""
            sign = ""
            binding.resultText.text=""
            answer=0.0
            setSign("")
            setInput()
        }

        binding.backBtn.setOnClickListener {
            if (!input.isNullOrBlank()) {
                input = input.dropLast(1)
                setInput()
            }
        }

    }
fun setTextFiel(str:String){
    binding.mathOperation.append(str)
}
    private fun setSign(sign: String) {
        if (input.isNullOrBlank()){
            firstValue = answer.toString()
            input = ""
            this.sign = sign
            setInput()
            presDot=false
        } else if (!input.isNullOrBlank() && !firstValue.isNullOrBlank()){
            when (sign) {
                SignEnums.PLUS.id -> {
                    firstValue = firstValue.toDouble().plus(input.toDouble()).toString()
                    input = ""
                    this.sign = sign
                    setInput()
                    presDot=false
                }
                SignEnums.MINUS.id -> {
                    firstValue = firstValue.toDouble().minus(input.toDouble()).toString()
                    input = ""
                    this.sign = sign
                    setInput()
                    presDot=false
                }
                SignEnums.DIVIDE.id -> {
                    firstValue = (firstValue.toDouble() / (input.toDouble())).toString()
                    input = ""
                    this.sign = sign
                    setInput()
                    presDot=false
                }
                SignEnums.MULTIPLY.id -> {
                    firstValue = (firstValue.toDouble() * (input.toDouble())).toString()
                    input = ""
                    this.sign = sign
                    setInput()
                    presDot=false
                }
                else -> {

                }
            }

        }
        else{
            firstValue = input
            input = ""
            this.sign = sign
            setInput()
            presDot=false
        }

    }

    private fun signBtnClick() {
        binding.plusBtn.setOnClickListener {
            setSign("+")
        }
        binding.minusBtn.setOnClickListener {
            setSign("-")
        }
        binding.divBtn.setOnClickListener {
            setSign("/")
        }
        binding.mltpBtn.setOnClickListener {
            setSign("*")
        }
    }

    private fun equalBtnClick() {
        binding.equalBtn.setOnClickListener {
            if (!input.isNullOrBlank() && !firstValue.isNullOrBlank()) {
                when (sign) {
                    SignEnums.PLUS.id -> {
                        answer = firstValue.toDouble().plus(input.toDouble())
                    }
                    SignEnums.MINUS.id -> {
                        answer = firstValue.toDouble().minus(input.toDouble())
                    }
                    SignEnums.DIVIDE.id -> {
                        answer = firstValue.toDouble() / (input.toDouble())
                    }
                    SignEnums.MULTIPLY.id -> {
                        answer = firstValue.toDouble() * (input.toDouble())
                    }
                    else -> {

                    }
                }
                setAnswer()
            } else {
               binding.resultText.text = input
            }

        }
    }
    private fun setInput() {
        binding.mathOperation.setText(input)
    }
        private fun setAnswer() {
            binding.resultText.text = answer.toString()
            firstValue = ""
            input = ""
            sign = ""
            presDot=false
        }
}