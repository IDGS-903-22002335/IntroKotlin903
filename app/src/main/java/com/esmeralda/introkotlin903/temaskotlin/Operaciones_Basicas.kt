package com.esmeralda.introkotlin903.temaskotlin

fun main(){





    do{

       println( "1.- suma " + "\n" +
                "2.- resta" + "\n"+
                "3.- multiplicación "+ "\n"+
                "4.- Divición "+ "\n"+
                "5.- Salir "+ "\n")

        println("Elige una opción: " )
        var opciones= readln().toInt()


        if (opciones == 1){
            println("Ingrese el primer numero : " )
            var numero1= readln().toDouble()

            println("Ingrese el segundo numero: ")
            var numero2= readln().toDouble()

           var resultado = numero1 + numero2

            println("El resultado de la suma es: $resultado")

        }
        if(opciones == 2){

            println("Ingrese el primer numero : " )
            var numero1= readln().toDouble()

            println("Ingrese el segundo numero: ")
            var numero2= readln().toDouble()

            var resultado = numero1 - numero2

            println("El resultado de la resta es: $resultado")
        }
        if(opciones == 3){

            println("Ingrese el primer numero : " )
            var numero1= readln().toDouble()

            println("Ingrese el segundo numero: ")
            var numero2= readln().toDouble()

            var resultado = numero1 * numero2

            println("El resultado de la multiplicacion es: $resultado")
        }
        if(opciones == 4){

            println("Ingrese el primer numero : " )
            var numero1= readln().toDouble()

            println("Ingrese el segundo numero: ")
            var numero2= readln().toDouble()

            var resultado = numero1 / numero2

            println("El resultado de la divicion es: $resultado")
        }
    }while(opciones != 5)

}