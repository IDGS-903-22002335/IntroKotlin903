package com.esmeralda.introkotlin903.practica4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.R
import java.io.FileNotFoundException

class ArchivosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_archivos)
        val btnGuardar = findViewById<Button>(R.id.sveButton)
        val btnLeer = findViewById<Button>(R.id.readButton)
        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        val outPut = findViewById<TextView>(R.id.outputText)
        val input = findViewById<EditText>(R.id.inputText)


        btnGuardar.setOnClickListener {
            val texto= input.text.toString()+"\n"
            //val archivo = openFileOutput("dato.txt", MODE_APPEND)
            try{
                openFileOutput("datos.txt", MODE_APPEND).use {
                    it.write(texto.toByteArray())
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        btnLeer.setOnClickListener {
            try{
                val contenido = openFileInput("datos.txt").bufferedReader().useLines { lines ->
                    lines.joinToString("\n")
                }
                outPut.text=contenido
            }catch (e:FileNotFoundException){gir
                outPut.text="Archivo no encontrado"
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}