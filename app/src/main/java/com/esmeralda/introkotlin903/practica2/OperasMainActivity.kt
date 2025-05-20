package com.esmeralda.introkotlin903.practica2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.R

class OperasMainActivity : AppCompatActivity() {
    private lateinit var edt1: EditText
    private lateinit var edt2: EditText
    private lateinit var btn1: Button
    private lateinit var tv1: TextView
    private lateinit var r1: RadioButton
    private lateinit var r2: RadioButton
    private lateinit var r3: RadioButton
    private lateinit var r4: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operas_main)
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        tv1 = findViewById(R.id.tv1)
        r1 = findViewById(R.id.r1)
        r2 = findViewById(R.id.r2)
        r3 = findViewById(R.id.r3)
        r4 = findViewById(R.id.r4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: android.view.View){

        val num1 = edt1.text.toString().toDouble()
        val num2 = edt2.text.toString().toDouble()
        var  resultado = 0.0

        if (r1.isChecked){
            resultado = num1 + num2


        }
        if(r2.isChecked){
            resultado = num1 - num2

        }

        if(r3.isChecked) {
            resultado = num1 * num2
        }

        if(r4.isChecked){
            resultado = num1 /num2
        }
        val resultado1 = "Resultado $resultado"
        tv1.text=resultado1
    }
}