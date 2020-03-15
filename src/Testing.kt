package com.merhab

fun main() {
    var rd =  MnRd();
    val str: String = rd.getClassName()
    //var c : Class<*>? = Class.forName(rd.javaClass.toString())
    println(str)
    rd.getFieldsToSave()
    for(fld in rd.getAllFields()){
        println( fld.name+"  "+ rd.getPropertyValue(fld))
    }
    rd.getFieldsToSave().forEach {println(it.typeName()) }

}