package com.raj.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.raj.calculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.allClearButton.setOnClickListener {
            binding.inputText.setText("")
            binding.outputText.setText("")
        }
        binding.backButton.setOnClickListener {
            val input_text = binding.inputText.text.toString()
            if (input_text.isNotEmpty()){
                binding.inputText.text = input_text.dropLast(1)
            }
            binding.outputText.text = ""
        }
        binding.divideButton.setOnClickListener {
            binding.inputText.append("/")
        }
        binding.sevenButton.setOnClickListener {
            binding.inputText.append("7")
        }
        binding.eightButton.setOnClickListener {
            binding.inputText.append("8")
        }
        binding.nineButton.setOnClickListener {
            binding.inputText.append("9")
        }
        binding.multiplyButton.setOnClickListener {
            binding.inputText.append("*")
        }
        binding.fourButton.setOnClickListener {
            binding.inputText.append("4")
        }
        binding.fiveButton.setOnClickListener {
            binding.inputText.append("5")
        }
        binding.sixButton.setOnClickListener {
            binding.inputText.append("6")
        }
        binding.substractButton.setOnClickListener {
            binding.inputText.append("-")
        }
        binding.oneButton.setOnClickListener {
            binding.inputText.append("1")
        }
        binding.twoButton.setOnClickListener {
            binding.inputText.append("2")
        }
        binding.threeButton.setOnClickListener {
            binding.inputText.append("3")
        }
        binding.addButton.setOnClickListener {
            binding.inputText.append("+")
        }
        binding.zeroButton.setOnClickListener {
            binding.inputText.append("0")
        }
        binding.dotButton.setOnClickListener {
            binding.inputText.append(".")
        }
        binding.resultButton.setOnClickListener {
            val input = binding.inputText.text.toString()
            if (input.isEmpty()){
                Toast.makeText(this,"enter the number",Toast.LENGTH_SHORT).show()
            }
            else if("**" in input){
                Toast.makeText(this,"Invalid pattern,Enter Number Correctly",Toast.LENGTH_SHORT).show()
            } else if("++" in input){
                Toast.makeText(this,"Invalid pattern,Enter Number Correctly",Toast.LENGTH_SHORT).show()
            } else if("//" in input){
                Toast.makeText(this,"Invalid pattern,Enter Number Correctly",Toast.LENGTH_SHORT).show()
            } else if("--" in input){
                Toast.makeText(this,"Invalid pattern,Enter Number Correctly",Toast.LENGTH_SHORT).show()
            } else {
                val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
                val validate = expression.validate()
                if (validate.isValid){
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble()) {
                        binding.outputText.text = longResult.toString()
                    } else {
                        binding.outputText.text = result.toString()
                    }
                } else {
                    Toast.makeText(this,"Invalid pattern, enter number correctly",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}