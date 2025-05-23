package com.esmeralda.introkotlin903.practica3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.R

class Ejemplo3MainActivity : AppCompatActivity() {
    private lateinit var tv1 : TextView
    private lateinit var edi1: EditText
    private lateinit var button: Button
    private var num= 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_ejemplo3_main)

        edi1 = findViewById(R.id.edi1)
        num = (Math.random() * 100001).toInt()

        val cadena = num.toString()
        val notificacion = Toast.makeText(this,cadena, Toast.LENGTH_LONG)
        notificacion.show()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun controler(View: android.view.View){
        val valorIngresado:String=edi1.text.toString()
        val valor=valorIngresado.toInt()

        if(valor==num)
        {
            val notificacion = Toast.makeText(this, "Correcto", Toast.LENGTH_LONG)
            notificacion.show()
        }
        else{
            val  notificacion = Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG)
            notificacion.show()
        }
    }

}