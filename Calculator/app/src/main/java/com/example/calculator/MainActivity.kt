package com.example.calculator

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Binding
    private lateinit var binding: ActivityMainBinding

    private var firstNumber = ""
    private var currentNumber = ""
    private var currentOperator = ""
    private var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize views
        binding.apply {
            // Get all buttons
            binding.layoutMain.children.filterIsInstance<Button>().forEach { button ->
                // Buttons click listener
                button.setOnClickListener {
                    // Get clicked button text
                    val buttonText = button.text.toString()
                    handleButtonClick(buttonText)
                }
            }
        }
    }

    // Handle button clicks
    private fun handleButtonClick(buttonText: String) {
        when {
            buttonText.matches(Regex("[0-9]")) -> handleNumberInput(buttonText)
            buttonText.matches(Regex("[+\\-*/]")) -> handleOperatorInput(buttonText)
            buttonText == "=" -> handleEquals()
            buttonText == "." -> handleDecimal()
            buttonText == "C" -> handleClear()
        }
    }

    // Handle number input
    private fun handleNumberInput(number: String) {
        if (currentOperator.isEmpty()) {
            firstNumber += number
            binding.tvResult.text = firstNumber
        } else {
            currentNumber += number
            binding.tvResult.text = currentNumber
        }
    }

    // Handle operator input
    private fun handleOperatorInput(operator: String) {
        if (firstNumber.isNotEmpty() && currentNumber.isEmpty()) {
            currentOperator = operator
            binding.tvResult.text = "0"
        }
    }

    // Handle equals input
    private fun handleEquals() {
        if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
            binding.tvFormula.text = "$firstNumber $currentOperator $currentNumber"
            result = evaluateExpression(firstNumber, currentNumber, currentOperator)
            firstNumber = result
            currentNumber = ""
            currentOperator = ""
            binding.tvResult.text = result
        }
    }

    // Handle decimal input
    private fun handleDecimal() {
        if (currentOperator.isEmpty()) {
            if (!firstNumber.contains(".")) {
                if (firstNumber.isEmpty()) firstNumber += "0."
                else firstNumber += "."
                binding.tvResult.text = firstNumber
            }
        } else {
            if (!currentNumber.contains(".")) {
                if (currentNumber.isEmpty()) currentNumber += "0."
                else currentNumber += "."
                binding.tvResult.text = currentNumber
            }
        }
    }

    // Handle clear input
    private fun handleClear() {
        firstNumber = ""
        currentNumber = ""
        currentOperator = ""
        binding.tvResult.text = "0"
        binding.tvFormula.text = ""
    }

    // Evaluate expression
    private fun evaluateExpression(firstNumber: String, secondNumber: String, operator: String): String {
        val num1 = firstNumber.toDoubleOrNull() ?: return ""
        val num2 = secondNumber.toDoubleOrNull() ?: return ""

        return when (operator) {
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "/" -> if (num2 != 0.0) (num1 / num2).toString() else "Error"
            else -> ""
        }
    }
}