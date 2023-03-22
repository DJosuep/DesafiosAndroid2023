package Conversion

import android.widget.RadioButton
import android.widget.RadioGroup

class Tipo {
    /* Se crea un mapa para el tipo de medida de cada opción en el RadioGroup */
    val tipo: Map<Int, String> = mapOf(
        0 to "km",
        1 to "m",
        2 to "cm"
    ).withDefault { "Error" }

    /* Retorna el Button que está seleccionado */
    fun findCheckRBId(rbgGroup: RadioGroup):Int{
        /* Obtiene el RadioButton seleccionado */
        val seleccionado:Int = rbgGroup.checkedRadioButtonId

        /* Comprueba si el ID seleccionado es -1 */
        if(seleccionado == -1){
            return -1
        }

        /* Crea un RadioButton para  */
        val radioButton = rbgGroup.findViewById<RadioButton>(seleccionado)
        return rbgGroup.indexOfChild(radioButton);
    }

    /* Regresa el tipo de medida como una cadena de texto */
    fun tipoMedida(index:Int):String{
        when(tipo[index]){
            "km" -> {return "km"}
            "m" -> {return "m"}
            "cm" -> {return "cm"}
        }

        return ""
    }
}