    package com.example.calculadora
    
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.TextView
    import androidx.appcompat.app.AlertDialog
    import androidx.appcompat.app.AppCompatActivity
    
    class MainActivity : AppCompatActivity() {
        private var num1EditText: EditText? = null
        private var num2EditText: EditText? = null
        private var resultTextView: TextView? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            num1EditText = findViewById(R.id.et_primernum)
            num2EditText = findViewById(R.id.et_segnum)
            resultTextView = findViewById(R.id.et_resultado)
            val addBtn = findViewById<Button>(R.id.suma)
            addBtn.setOnClickListener {
                if (validateFields()) {
                    performOperation('+')
                } else {
                    showAlert("Por favor, complete ambos campos.")
                }
            }
            val subtractBtn = findViewById<Button>(R.id.resta)
            subtractBtn.setOnClickListener {
                if (validateFields()) {
                    performOperation('-')
                } else {
                    showAlert("Por favor, complete ambos campos.")
                }
            }
            val multiplyBtn = findViewById<Button>(R.id.multiplicacion)
            multiplyBtn.setOnClickListener {
                if (validateFields()) {
                    performOperation('*')
                } else {
                    showAlert("Por favor, complete ambos campos.")
                }
            }
            val divideBtn = findViewById<Button>(R.id.division)
            divideBtn.setOnClickListener {
                if (validateFields()) {
                    performOperation('/')
                } else {
                    showAlert("Por favor, complete ambos campos.")
                }
            }
            val exitBtn = findViewById<Button>(R.id.exitBtn)
            exitBtn.setOnClickListener { finish() }
        }
    
        private fun validateFields(): Boolean {
            val num1 = num1EditText!!.text.toString().trim { it <= ' ' }
            val num2 = num2EditText!!.text.toString().trim { it <= ' ' }
            return !num1.isEmpty() && !num2.isEmpty()
        }
    
        private fun performOperation(operator: Char) {
            val num1 = num1EditText!!.text.toString().toDouble()
            val num2 = num2EditText!!.text.toString().toDouble()
            var result = 0.0
            when (operator) {
                '+' -> result = num1 + num2
                '-' -> result = num1 - num2
                '*' -> result = num1 * num2
                '/' -> if (num2 != 0.0) {
                    result = num1 / num2
                } else {
                    resultTextView!!.text = "Error: División entre cero"
                    return
                }
            }
            resultTextView!!.text = result.toString()
        }
    
        private fun showAlert(message: String) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alerta")
                .setMessage(message)
                .setPositiveButton("Aceptar", null)
                .show()
        }
    }