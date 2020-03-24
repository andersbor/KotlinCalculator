package dk.easj.anbo.calculator3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainCalculateButton.setOnClickListener {
            val number1Str = this.mainNumber1EditText.text.toString().trim()
            if (number1Str.isEmpty()) {
                mainNumber1EditText.error = "Not a number"
                return@setOnClickListener
            }
            val number2Str = mainNumber2EditText.text.toString().trim()
            if (number2Str.isEmpty()) {
                mainNumber2EditText.error = "Not a number"
                return@setOnClickListener
            }
            val number1 = number1Str.toDouble()
            val number2 = number2Str.toDouble()
            var result = 0.0
            val selectedItem = mainOperationSpinner.selectedItem
            Log.d("MINE", selectedItem.toString())
            when (selectedItem) { // https://kotlinlang.org/docs/reference/control-flow.html
                "+" -> result = number1 + number2
                "-" -> result = number1 - number2
                "*" -> result = number1 * number2
                "/" -> result = number1 / number2
            }
            val resultStr = result.toString()
            mainResultEditText.setText(resultStr)
        }
    }
}

