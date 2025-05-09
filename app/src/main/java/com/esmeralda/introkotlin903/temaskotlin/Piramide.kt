package com.esmeralda.introkotlin903.temaskotlin

fun main(){
/*
Practica 3 imprimir una piramide de * segun el numero dato por el usuario
n = 5
*
**
***
****
*****
Cuando se capture un 0 terminar el programa, utilizando puro do-while
 */
    do {


        println("Introdusca un numero")
        var numero = readln().toInt()
        var n = 0
        var a = "*"
        var o = ""
        do {
            o+=a
            println(o)

            n++
        } while (n < numero)
    }while(numero != 0)

}