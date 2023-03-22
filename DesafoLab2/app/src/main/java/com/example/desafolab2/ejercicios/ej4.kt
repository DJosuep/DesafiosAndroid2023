package com.example.desafolab2.ejercicios

fun palabrasSpanglish(){
    val palabrasEn = arrayOf("Butterfly", "Window", "Program", "Desk", "Five", "Array", "Chain", "Folder", "Glass", "Ten", "Sky", "Reverse", "Word", "Mouse", "Fifteen", "Keyboard", "Space", "Key", "Light", "Eye")
    val palabrasEs = arrayOf("Mariposa", "Ventana", "Programa", "Escritorio", "Cinco", "Arreglo", "Cadena", "Carpeta", "Vidrio", "Diez", "Cielo", "Reversa", "Palabra", "Mouse", "Quince", "Teclado", "Espacio", "Llave", "Luz", "Ojo")

    println("(4) Palabras en español e inglés:\n")

    println("Español\t\t\tEnglish\n")

    for(i in 0..19){
        println("${palabrasEs[i]}\t\t\t${palabrasEn[i]}\n")
    }
}