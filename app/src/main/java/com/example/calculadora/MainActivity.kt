package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var edtDisplay: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtDisplay = findViewById(R.id.edtDisplay)

        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btn0: Button = findViewById(R.id.btn0)
        val btnDot: Button = findViewById(R.id.btnDot)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnDelete: Button = findViewById(R.id.btnDelete)
        val btnEquals: Button = findViewById(R.id.btnEquals)

        btn1.setOnClickListener { edtDisplay.append("1") }
        btn2.setOnClickListener { edtDisplay.append("2") }
        btn3.setOnClickListener { edtDisplay.append("3") }
        btn4.setOnClickListener { edtDisplay.append("4") }
        btn5.setOnClickListener { edtDisplay.append("5") }
        btn6.setOnClickListener { edtDisplay.append("6") }
        btn7.setOnClickListener { edtDisplay.append("7") }
        btn8.setOnClickListener { edtDisplay.append("8") }
        btn9.setOnClickListener { edtDisplay.append("9") }
        btn0.setOnClickListener { edtDisplay.append("0") }
        btnDot.setOnClickListener { edtDisplay.append(".") }
        btnAdd.setOnClickListener { edtDisplay.append("+") }
        btnSubtract.setOnClickListener { edtDisplay.append("-") }
        btnMultiply.setOnClickListener { edtDisplay.append("*") }
        btnDivide.setOnClickListener { edtDisplay.append("/") }
        btnClear.setOnClickListener { edtDisplay.text.clear() }
        btnDelete.setOnClickListener {
            val text = edtDisplay.text
            if (text.isNotEmpty()) {
                edtDisplay.setText(text.substring(0, text.length - 1))
            }
        }
        btnEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(edtDisplay.text.toString()).build()
                val result = expression.evaluate()
                edtDisplay.setText(result.toString())
            } catch (e: Exception) {
                edtDisplay.setText("Error")
            }
        }
    }
}
