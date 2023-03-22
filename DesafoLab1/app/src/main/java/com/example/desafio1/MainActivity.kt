package com.example.desafio1

import Conversion.Convertir
import Conversion.Tipo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Obteniendo datos de RadioGroups */
        val rgOrigen: RadioGroup = findViewById(R.id.rgOrigen)
        val rgDestino: RadioGroup = findViewById(R.id.rgDestino)

        /* Obtiene otros valores, como el número ingresado por el usuario y algunas vistas */
        val editNum: EditText = findViewById(R.id.editNum)
        val btnConvertir: Button = findViewById(R.id.btnConvertir) /* Crea un Button para usar el evento clic*/
        val tvResultado: TextView = findViewById(R.id.tvResultado) /* Crea un TextView para mostrar el resultado */

        btnConvertir.setOnClickListener {
            val origen: Int = Tipo().findCheckRBId(rgOrigen) /* Index del RadioGroup de origen*/
            val destino: Int = Tipo().findCheckRBId(rgDestino) /* Index del RadioGroup de destino*/

            /* Si el número está vacío */
            if (editNum.text.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Faltan valores en el campo de texto.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            /* Si alguno de los RadioButtons está deseleccionado */
            if(origen == -1 || destino == -1){
                Toast.makeText(getApplicationContext(), "Debe seleccionar el tipo de medida.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            /* Guarda el número ingresado por el usuario */
            val numIngresado:Float = editNum.text.toString().toFloat()

            /* Conversión */
            val tipo:String = Tipo().tipoMedida(destino)
            val resultado:Float = Convertir().convertir(numIngresado, origen, destino)
            val mostrar = "$resultado $tipo"
            tvResultado.text = mostrar
        }
    }
}