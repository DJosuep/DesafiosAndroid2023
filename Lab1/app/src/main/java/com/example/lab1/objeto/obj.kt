package com.example.lab1.objeto

class planeta constructor(nombre:String, satelites:Int, masa:Double, volumen:Double, distanciaSol:Int, tipo:String){
    var nombre:String = ""
    var satelites:Int = 0
    var masa:Double = 0.0
    var volumen:Double = 0.0
    var distanciaSol:Int = 0
    var tipo = listOf<String>(
        "Terrestre",
        "Gaseoso",
        "Enano"
    )

    private fun tipo():Int {
        /* Aquí se debería verificar si el tipo que recibe coincide con alguno de los tipos que salen en la lista */
        return 1
    }

    fun nose(){
        println("El nombre del planeta es ${nombre} y tiene ${satelites} satélites, es un planeta ${tipo()}, su masa es de ${masa} kg y su volumen es de ${volumen} kg.\nAdemás, su distancia con respecto al sol es de ${distanciaSol} millones de kilómetros.")
    }
}