package com.esmeralda.introkotlin903.temaskotlin

fun main(){
    println("Ingrese el sueldo del empleado: ")
    val sueldo = readln().toDouble() // readln permite leer los valores desde la consola despues se pone un punto y funcion del tipo de dato que aceptan

    if(sueldo > 3000){
        println( "Debe pagar impuestos")
    }else{
        println("No debe pagar impuestos")
    }
}