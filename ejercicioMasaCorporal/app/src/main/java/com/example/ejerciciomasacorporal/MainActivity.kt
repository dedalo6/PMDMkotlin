package com.example.ejerciciomasacorporal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val primeraEntrada: EditText = findViewById(R.id.primerEditTextText)
        val segundaEntrada: EditText = findViewById(R.id.segundoEditTextText)
        val miBoton: Button = findViewById(R.id.miBtn)
        val textViewNumero : TextView = findViewById(R.id.textViewNumero)
        val miTextView: TextView = findViewById(R.id.miTextView)


        miBoton.setOnClickListener {
            //Mira si es null y si lo es pone un numero predefinido 0.0 o 1.0
            val primerValor: Double = primeraEntrada.text.toString().toDoubleOrNull() ?: 0.0
            val segundoValor: Double = segundaEntrada.text.toString().toDoubleOrNull() ?: 1.0


            if (segundoValor != 0.0) {//Nos aseguramos de que no dividimos por 0
                val miVariable: Double = primerValor / Math.pow(segundoValor, 2.0)

                textViewNumero.text = miVariable.toString()
                when {
                    miVariable < 18.5 -> miTextView.text = "Usted sufre delgadez, debería comer más."
                    miVariable >= 18.5 && miVariable < 24.9 -> miTextView.text = "Su estado de forma es bueno."
                    miVariable >= 24.9 && miVariable < 29.9 -> miTextView.text = "Usted sufre sobrepeso, debería cuidarse y llamar a un dietista."
                    miVariable >= 29.9 -> miTextView.text = "Usted sufre obesidad, debería llamar a un médico urgentemente"
                }
            } else {
                println("Error: El segundo valor no puede ser cero.")
            }
        }
    }
}
