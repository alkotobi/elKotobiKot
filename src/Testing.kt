package com.merhab

fun main() {
    var rd =  MnRd();
    val str: String = rd.getClassName()
    //var c : Class<*>? = Class.forName(rd.javaClass.toString())
    println(str)
    rd.getFieldsArray()
    for(fld in rd.getFieldsArray()){
        println(fld.toString())
    }
}