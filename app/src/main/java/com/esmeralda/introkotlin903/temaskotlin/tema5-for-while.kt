package com.esmeralda.introkotlin903.temaskotlin

fun main(){
    /*
    Range()-> se cuencia de numero que pongas dentro del parentesis
    1..4=1,2,3,4
    1..<4=1,2,3
    4 downTo 1 = 4,3,2,1
    1..5 step 2 = 1,3,5
    'a'..'z = a,b,c,d,e,f,g...z

     */
    /*
    for recorre un conjunto de datos
     */

    for(num in 1..5){
        println(num)
    }

    println("While")
    val num = 10
    var d =0
    while(d < num){
        println(d)
        d++
    }

    val frutas = listOf("Manzana","Pera","Frambueza", "Durazno")

    for(fruta in frutas)
    {
        println(fruta)
    }

    /*
    Practica 3 imprimir una piramide de * segun el numero dato por el usuario
    n = 5
    *
    **
    ***
    ****
    *****
    Cuando se capture un 0 terminar el programa, utilizando puro do-while
    Practica 3: formula general de la serie de finabacci
     */



}