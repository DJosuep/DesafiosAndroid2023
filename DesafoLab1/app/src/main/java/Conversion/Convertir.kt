package Conversion

class Convertir {
    fun convertir(num:Float, tipoOrigen:Int, tipoDestino:Int):Float{
        if(tipoOrigen == 0){
            when(tipoDestino){
                /* Kilómetros a kilómetros */
                0 -> { return num }

                /* Kilómetros a metros */
                1 -> {
                    return num * 1000
                }

                /* Kilómetros a centímetros */
                2 -> {
                    return num * 100000
                }
            }
        }
        else if(tipoOrigen == 1){
            when(tipoDestino){
                /* Metros a kilómetros */
                0 -> {
                    return num * 0.001F
                }

                /* Metros a metros */
                1 -> { return num }

                /* Metros a centímetros */
                2 -> {
                    return num * 100
                }
            }
        }
        else if(tipoOrigen == 2){
            when(tipoDestino){
                /* Centímetros a kilómetros*/
                0 -> {
                    return num / 100000
                }

                /* Centímetros a metros */
                1 -> {
                    return num * 0.01F
                }

                /* Centímetros a centímetros*/
                2 -> { return num }
            }
        }

        return 0F
    }
}