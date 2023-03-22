package com.example.lab1.ejercicio3

enum class TipoVehiculo{
    AUTOMOVIL, TRACTOR, BUS, CAMIONETA
}

class Vehiculo(private var marca:String, private var capacidad:Int, private var tipo:TipoVehiculo, private var estadoVehiculo:Boolean) {
    init {
        println("La marca del vehículo es ${marca} y su capacidad es de ${capacidad} personas.")
        println("El vehículo es un ${tipo}.")
    }

    fun encender(){
        estadoVehiculo = true
    }

    fun apagar(){
        estadoVehiculo = false
    }

    fun getEstadoVehiculo():String{
        if (estadoVehiculo){
            return "El vehículo está encendido"
        }
        return "El vehículo está apagado"
    }

    fun setEstadoVehiculo(estadoNuevo:Boolean){
        estadoVehiculo = estadoNuevo
    }
}

fun ej3(){
    println("\n------------------ Ejercicio (3) ------------------\n")

    var vehiculo1 = Vehiculo("Toyota", 4, TipoVehiculo.AUTOMOVIL, false)

    vehiculo1.setEstadoVehiculo(true)

    println("Estado: ${vehiculo1.getEstadoVehiculo()}.\n")

    var vehiculo2 = Vehiculo("Nissan", 6, TipoVehiculo.CAMIONETA, true)

    vehiculo2.setEstadoVehiculo(false)

    println("Estado: ${vehiculo1.getEstadoVehiculo()}.")
}