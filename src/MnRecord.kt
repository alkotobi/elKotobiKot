package com.merhab

import java.lang.reflect.Field

open class MnRecord(var id: Int =-1) {
    private var n =-1
    protected var m =-1
    open var rdt =-1



    fun getClassName(): String {
        return this.javaClass.name
    }

    protected fun getSupClassesArray():Array<Class<*>>{
        var ar :MutableList<Class<*>> = mutableListOf(this.javaClass)
        var cls:Class<*> = this.javaClass
        while (cls.name!="com.merhab.MnRecord"){
            cls=cls.superclass
            ar.add(cls)
        };
        return ar.toTypedArray();

    }

    fun getFieldsArray():Array<Field>{
        var ar :MutableList<Field> = mutableListOf()
       for (cls in getSupClassesArray()){
           ar.addAll(cls.declaredFields.filter { field -> field.name.startsWith("rd")  })
       }
        return ar.toTypedArray()
    }

}

class MnRd(id: Int =-1) : MnRecord(id) {
    var rdnono =-1
}
