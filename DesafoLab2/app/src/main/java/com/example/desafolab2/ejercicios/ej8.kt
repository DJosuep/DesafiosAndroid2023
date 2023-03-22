package com.example.desafolab2.ejercicios

fun salarioSemanalTrab(){
    println("(8) Calcular el salario semanal con base en las horas trabajadas:\n")

    do {
        println("Ingrese las horas trabajadas en la semana:")
        var horas:Int? = readLine()?.toIntOrNull()

        /* Validaciones */
        if (horas != null && horas > 0 && horas < 168){
            val salario:Int?
            if (horas < 41){
                salario = (horas * 12) * 7
            }
            else{
                salario = (horas * 16) * 7
            }
            println("El salario semanal es de $$salario.")
        }
        else{
            println("\nVerifique que los valores ingresados sean correctos o que no sean muy grandes.\n")
        }
    }while (horas == null)
}