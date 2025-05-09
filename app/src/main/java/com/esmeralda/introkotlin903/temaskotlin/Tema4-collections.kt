package com.esmeralda.introkotlin903.temaskotlin

fun main(){

    /*
    * List                  "Lista simple permite datos repetidos no puedes cambiar sus valore"
    * MultableList          "Lista simple permite datos repetidos puedes cambiar sus valore"
    * set                    "Solo admite datos unicos"
    * MultableSet*           "Solo admite datos unicos puedes cambiar su valor"
      Map                    ""
      MultableMap            "Puede cambiar su valor"
     */

    var lista = listOf<String>("Lunes", "Martes", "Miercoles")

    println(lista)  //Datos que contiene la lista
    println(lista.size) //cuantos valores tiene la ista
    println(lista.get(0)) // Da el valor del cual indicas la posicion
    println(lista[1]) // Da el valor del cua indicas la posicion
    println(lista.indexOf("Miercoles")) // busca si el dato esta en la lista
    println(lista.first()) // Da el primer valor
    println(lista.last()) // Da el ultimo valor


    var listaMutable = mutableListOf<String>("Lunes", "Martes", "Miercoles")
    println(listaMutable)
    listaMutable.add("Jueves") // agrega jueves a la lista mutable
    println(listaMutable)
    listaMutable.removeAt(0) // remueve el elemento de la posicion 0
    println(listaMutable)
    listaMutable.add(0,"Domingo") // Añadir el elemento Domingo en la posición 0
    println(listaMutable)
    listaMutable.remove("Miercoles") // Eliminar el elemento Miercoles

}