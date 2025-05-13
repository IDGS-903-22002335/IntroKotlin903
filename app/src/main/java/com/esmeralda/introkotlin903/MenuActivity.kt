package com.esmeralda.introkotlin903

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.ejemplo.cineActivity
import com.esmeralda.introkotlin903.practica1.saludoActivity
import com.esmeralda.introkotlin903.practica2.OperasMainActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu2)
        val btnSaludo = findViewById<Button>(R.id.btn1)  // para que me mande a otra ventana
        val btnCalcular = findViewById<Button>(R.id.btn2)
        val btnCine = findViewById<Button>(R.id.btn3
        )
        btnSaludo.setOnClickListener { navegateToSaludo() }
        btnCalcular.setOnClickListener { operaciones() }
        btnCine.setOnClickListener { cine() }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun cine() {
        val intent = Intent(this, cineActivity::class.java)
        startActivity(intent)    }

    private fun operaciones() {
        val intent = Intent(this, OperasMainActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, saludoActivity::class.java)
        startActivity(intent)
    }
}