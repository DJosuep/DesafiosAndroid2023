package com.example.lab1.ejercicio2

data class SuperHeroe(var personaje:String, var pelicula:String, var nombreReal:String, var anyoPublicacion:Int)
data class SuperHeroeInmutable(val personaje:String, val pelicula:String, val nombreReal:String, val anyoPublicacion:Int)

fun ej2(){
    var heroe1 = SuperHeroe("Spider-Man", "Spider-Man", "Peter Parker", 2002)

    println("\n------------------ Ejercicio (2) ------------------")

    println("\n---Héroe original:\nHéroe: ${heroe1.personaje}.\nPelícula: ${heroe1.pelicula}.")
    println("Nombre real: ${heroe1.nombreReal}.\nAño de publicación: ${heroe1.anyoPublicacion}.")

    heroe1.pelicula = "El hombre araña"

    println("\n---Héroe modificado:\nHéroe: ${heroe1.personaje}.\nPelícula: ${heroe1.pelicula}.")
    println("Nombre real: ${heroe1.nombreReal}.\nAño de publicación: ${heroe1.anyoPublicacion}.")

    /* Creando lista mutable de la data class SuperHeroeInmutable */
    var lista: MutableList<SuperHeroeInmutable> = mutableListOf(
        SuperHeroeInmutable("Goku", "Dragon Ball", "Kakaroto", 1998),
        SuperHeroeInmutable("Linterna verde", "Linterna verde", "Hal Jordan", 2011),
        SuperHeroeInmutable("Ant-Man", "Ant-Man", "Scott Lang", 2015),
        SuperHeroeInmutable("Iron Man", "Iron Man", "Anthony Stark", 2008)
    )

    println("\nLa cantidad de elementos en la lista mutable es de ${lista.size}.")
    println("El primer elemento de la lista es: ${lista.first()}.")
    println("El segundo elemento de la lista es: ${lista[2]}.")
    println("El último elemento de la lista es: ${lista.last()}.\n")

    for (heroe in lista){
        println("Personaje: " + heroe.component1() + ".\tPelícula: " + heroe.component2())
    }
}