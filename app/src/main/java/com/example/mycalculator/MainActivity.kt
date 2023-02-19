package com.example.mycalculator
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lastNumeric: Boolean = false

    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }

        fun onDigit(view: View) {

            tvInput.append((view as Button).text)
            lastNumeric = true


        }
    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(tvInput.text.toString())) {
            tvInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }

    }
        fun onClear(view: View) {
            tvInput.text = ""
            lastNumeric = false
            lastDot = false

        }

    fun onDecimalPoint(view: View) {

        if (lastNumeric && !lastDot) {
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }

    }



    }

    private fun isOperatorAdded(value: String): Boolean {


        return if (value.startsWith("-")) {
            false
        } else {
            (value.contains("/")
                    || value.contains("*")
                    || value.contains("-")
                    || value.contains("+"))
        }
    }
