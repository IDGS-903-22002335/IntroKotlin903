package com.esmeralda.introkotlin903.temaskotlin

// Sin constructor
class usuarios() {
    // La manera de finir un atributo
    val materia:String= ""

}

// Clase con constructor
class usuarios2(val id: Int, val nombre:String){
    val materia: String=""
    fun hola(){
        println("hola")
    }
}

fun main(){
    //Instancia
    val alumno = usuarios()
    val alumno2 = usuarios2(1,"Esmeralda")

    //Hacer referencia a las propiedades de la clase
    println(alumno2.id)
    println(alumno2.nombre)

    alumno2.hola()
}