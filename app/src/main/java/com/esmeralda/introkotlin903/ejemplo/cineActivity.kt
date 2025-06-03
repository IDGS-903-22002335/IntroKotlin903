package com.esmeralda.introkotlin903.ejemplo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmeralda.introkotlin903.R

class cineActivity : AppCompatActivity() {
    private lateinit var buyersEditText:EditText
    private lateinit var yesRadioButton: RadioButton
    private lateinit var  noRadioButton: RadioButton
    private lateinit var cantidad: EditText
    private lateinit var calculateButton: Button
    private lateinit var totalTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cine)

        buyersEditText = findViewById(R.id.buyersEditText)
        yesRadioButton = findViewById(R.id.yesRadioButton)
        noRadioButton = findViewById(R.id.noRadioButton)
        cantidad = findViewById(R.id.cantidad)
        calculateButton = findViewById(R.id.calculateButton)
        totalTextView = findViewById(R.id.totalTextView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun costo(view: android.view.View){
        var personas=  buyersEditText.text.toString().toDouble()
        val boletoxpersona = 7
        val boletos = 12
        var pago = (0).toDouble()
        var descuento = (0).toDouble()
        var cantidadDeBoletos = cantidad.text.toString().toDouble()


        val voletosAComprar = personas * boletoxpersona

        if(cantidadDeBoletos > voletosAComprar){
            AlertDialog.Builder(this)
                .setTitle("Boletos")
                .setMessage("Solo se pueden comprar 7 boletos por persona")
                .setPositiveButton("OK") { dialog, which ->
                    cantidad.text.clear()
                }
                .show()
        }
        else{
            pago=  cantidadDeBoletos * boletos
            if(cantidadDeBoletos > 5){
                descuento = pago * 0.15


                pago = pago - descuento

            }
            else if(cantidadDeBoletos >= 3 && cantidadDeBoletos <= 5){
                descuento = pago * 0.10

                pago = pago - descuento
            }
            else{
            }
            if(yesRadioButton.isChecked){
                descuento = pago  * 0.10

                pago =  pago - descuento
            }

            val resultado = "El dinero a pagar es $pago"
            totalTextView.text = resultado
        }
    }
}