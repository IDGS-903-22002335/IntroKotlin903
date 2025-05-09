package com.esmeralda.introkotlin903.temaskotlin

import kotlin.math.sqrt

fun main(){
    /*

  Practica 3: formula general
   */
    do {
        var constante = 2

        println("Ingresa el valor de a")
        var a = readln().toDouble()
        println("Ingre el valor de b")
        var b = readln().toDouble()
        println("Ingresa el c")
        var c = readln().toDouble()


        var va1 = Math.pow(b,2.0) - 4*a*c // Calculo el discriminante

        if (va1.toInt() >= 0 ){

           var x1 = (- b + sqrt(va1) )/ (constante * a)
            println("x1= $x1")
        }
        if(va1.toInt() >= 0){
            var x2 = (- b - sqrt(va1) )/ (constante * a)
            println("x2 = $x2")
        }
        if(a.toInt() ==0){
            println("No es valido a = $a")
        }
    } while(va1.toInt() < 0 || a.toInt() == 0)


}