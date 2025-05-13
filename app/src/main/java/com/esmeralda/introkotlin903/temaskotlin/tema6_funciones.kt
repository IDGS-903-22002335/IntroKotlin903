package com.esmeralda.introkotlin903.temaskotlin

//                       indica el tipo de dato que devuelve
fun sum(x: Int, y: Int): Int{
    return x + y

}

// funcion de linea , se quita el return pero devuelve el resultado de la suma
fun sum2(x: Int, y: Int) = x + y

fun main(){

    println(sum(6,5))
    println(sum2(9, 7))
}