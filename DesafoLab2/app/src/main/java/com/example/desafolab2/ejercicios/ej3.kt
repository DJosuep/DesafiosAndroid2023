package com.example.desafolab2.ejercicios

fun salarioSemanalColab(){
    val paga = 12

    print("(3) Calcular el salario semanal con base en las horas trabajadas:")
    do {
        println("\nIngrese las horas trabajadas en la semana:\n")
        var horas = readLine()?.toIntOrNull()

        /* Validaciones */
        if (horas != null && horas > 0 && horas < 168){
            val salario = (paga * horas) * 7
            println("\nEl salario semanal es de $$salario.")
        }
        else{
            println("\nVerifique que los valores ingresados sean correctos o que no sean muy grandes.\n")
        }
    }while (horas == null)
}