package com.esmeralda.introkotlin903.Diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.R

class DiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        val capturarPalabra = findViewById<Button>(R.id.button2)
        val buscar = findViewById<Button>(R.id.button3)

        capturarPalabra.setOnClickListener { captura() }
        buscar.setOnClickListener { buscar() }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }

    private fun buscar(){
        val intent = Intent (this, BuscarActivity::class.java)
        startActivity(intent)
    }
    private fun captura() {
        val intent = Intent(this, CapturarPalabraActivity::class.java)
        startActivity(intent)
    }
}