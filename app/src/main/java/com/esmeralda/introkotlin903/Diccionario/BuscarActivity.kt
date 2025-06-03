package com.esmeralda.introkotlin903.Diccionario

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.R // Asegúrate de que tu archivo R esté importado

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.io.IOException

/**
 * Actividad para buscar palabras (inglés o español) en un archivo de texto.
 * Muestra la traducción si la palabra es encontrada, o un mensaje de "no encontrada".
 */
class BuscarActivity : AppCompatActivity() {

    // Declaración de las vistas para poder acceder a ellas en toda la clase.
    private lateinit var languageRadioGroup: RadioGroup
    private lateinit var radioSpanish: RadioButton
    private lateinit var radioEnglish: RadioButton
    private lateinit var wordToSearchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var foundWordLabel: TextView
    private lateinit var resultWordTextView: TextView
    private lateinit var returnToMenuButton: Button

    private val FILENAME = "palabras_diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        languageRadioGroup = findViewById(R.id.languageRadioGroup)
        radioSpanish = findViewById(R.id.radioSpanish)
        radioEnglish = findViewById(R.id.radioEnglish)
        wordToSearchEditText = findViewById(R.id.wordToSearchEditText)
        searchButton = findViewById(R.id.searchButton)
        foundWordLabel = findViewById(R.id.foundWordLabel)
        resultWordTextView = findViewById(R.id.resultWordTextView)
        returnToMenuButton = findViewById(R.id.returnToMenuButton)


        foundWordLabel.visibility = TextView.GONE
        resultWordTextView.visibility = TextView.GONE

        searchButton.setOnClickListener {
            searchWord()
        }

        returnToMenuButton.setOnClickListener {
            returnToMenu()
        }

        languageRadioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioSpanish -> {
                    wordToSearchEditText.hint = "Ingresa palabra en inglés"
                }
                R.id.radioEnglish -> {
                    wordToSearchEditText.hint = "Ingresa palabra en español"
                }
            }
            wordToSearchEditText.text.clear()
            foundWordLabel.visibility = TextView.GONE
            resultWordTextView.visibility = TextView.GONE
        }

        wordToSearchEditText.hint = "Ingresa palabra en inglés"
    }


    private fun searchWord() {
        val wordToFind = wordToSearchEditText.text.toString().trim()

        if (wordToFind.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa una palabra para buscar.", Toast.LENGTH_SHORT).show()
            return
        }

        foundWordLabel.visibility = TextView.GONE
        resultWordTextView.visibility = TextView.GONE

        var foundTranslation: String? = null
        var fis: FileInputStream? = null
        var isr: InputStreamReader? = null
        var br: BufferedReader? = null

        try {
            fis = openFileInput(FILENAME)
            isr = InputStreamReader(fis)
            br = BufferedReader(isr)

            var line: String?
            while (br.readLine().also { line = it } != null) {
                val parts = line?.split(",")
                if (parts != null && parts.size == 2) {
                    val spanish = parts[0].trim()
                    val english = parts[1].trim()


                    if (radioSpanish.isChecked) {

                        if (english.equals(wordToFind, ignoreCase = true)) {
                            foundTranslation = spanish
                            break
                        }
                    } else {
                        if (spanish.equals(wordToFind, ignoreCase = true)) {
                            foundTranslation = english
                            break
                        }
                    }
                }
            }

            if (foundTranslation != null) {
                foundWordLabel.text = "Palabra encontrada"
                foundWordLabel.visibility = TextView.VISIBLE
                resultWordTextView.text = foundTranslation
                resultWordTextView.visibility = TextView.VISIBLE
            } else {
                foundWordLabel.text = "Palabra no encontrada"
                foundWordLabel.visibility = TextView.VISIBLE
                resultWordTextView.text = ""
                resultWordTextView.visibility = TextView.GONE
            }

        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al leer el archivo de palabras: ${e.message}", Toast.LENGTH_LONG).show()
            foundWordLabel.text = "Error al buscar"
            foundWordLabel.visibility = TextView.VISIBLE
            resultWordTextView.visibility = TextView.GONE
        } finally {

            try {
                br?.close()
                isr?.close()
                fis?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun returnToMenu() {
        val intent = Intent(this, DiccionarioActivity::class.java)
        startActivity(intent)
        finish()
    }
}
