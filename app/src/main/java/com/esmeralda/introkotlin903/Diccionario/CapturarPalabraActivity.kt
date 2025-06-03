package com.esmeralda.introkotlin903.Diccionario

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.R

import java.io.FileOutputStream
import java.io.IOException


class CapturarPalabraActivity : AppCompatActivity() {

    private lateinit var spanishEditText: EditText
    private lateinit var englishEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var successMessageTextView: TextView
    private lateinit var returnToMenuButton: Button


    private val FILENAME = "palabras_diccionario.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar_palabra)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        spanishEditText = findViewById(R.id.spanishEditText)
        englishEditText = findViewById(R.id.englishEditText)
        saveButton = findViewById(R.id.saveButton)
        successMessageTextView = findViewById(R.id.successMessageTextView)
        returnToMenuButton = findViewById(R.id.returnToMenuButton)


        successMessageTextView.visibility = TextView.GONE


        saveButton.setOnClickListener {
            saveWordPair()
        }


        returnToMenuButton.setOnClickListener {
            returnToMenu()
        }
    }


    private fun saveWordPair() {
        val spanishWord = spanishEditText.text.toString().trim()
        val englishWord = englishEditText.text.toString().trim()

        if (spanishWord.isEmpty() || englishWord.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambas palabras.", Toast.LENGTH_SHORT).show()
            return
        }

        val dataToSave = "$spanishWord,$englishWord\n"

        var fos: FileOutputStream? = null
        try {

            fos = openFileOutput(FILENAME, Context.MODE_APPEND)
            fos.write(dataToSave.toByteArray())
            Toast.makeText(this, "Palabra guardada con éxito.", Toast.LENGTH_SHORT).show()
            showSuccessMessage()
            clearInputFields()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar la palabra: ${e.message}", Toast.LENGTH_LONG).show()
        } finally {

            fos?.close()
        }
    }


    private fun showSuccessMessage() {
        successMessageTextView.visibility = TextView.VISIBLE
        Handler(Looper.getMainLooper()).postDelayed({
            successMessageTextView.visibility = TextView.GONE
        }, 3000)
    }


    private fun clearInputFields() {
        spanishEditText.text.clear()
        englishEditText.text.clear()
        spanishEditText.requestFocus()
    }


    private fun returnToMenu() {
        val intent = Intent(this, DiccionarioActivity::class.java)
        startActivity(intent)
        finish()
    }
}
