package com.merhab

import java.lang.reflect.Field
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

open class MnRecord(var rdid: Int =-1) {
     var ign =-1
     var m:Double =-1.00
     var rdt =" "



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



    fun getPropertyValue(property:KProperty1<out Any, Any?>): Any? {
        return readInstanceProperty(this,property.name)
    }

    @Suppress("UNCHECKED_CAST")
   protected fun <R> readInstanceProperty(instance: Any, propertyName: String): R {
        val properties = instance::class.memberProperties
            // don't cast here to <Any, R>, it would succeed silently
            .first { it.name == propertyName } as KProperty1<Any, *>
        // force a invalid cast exception if incorrect type here
        return properties.get(instance) as R
    }

     fun  getAllFields(): Collection<KProperty1<out Any, Any?>> = this::class.memberProperties
            // don't cast here to <Any, R>, it would succeed silently
        // force a invalid cast exception if incorrect type here

    // the record filed that will b saved to loacal or remote database should not start with ig
    // it is not a perfect solution I know it
    // I will think later for a better way
    fun  getFieldsToSave(): Collection<KProperty1<out Any, Any?>> = this::class.memberProperties
        .filter { !it.name.startsWith("ig") }
        // don't cast here to <Any, R>, it would succeed silently
        // force a invalid cast exception if incorrect type here



}



class MnRd(id: Int =-1) : MnRecord(id) {
    var igrdnono =-1
}

fun KProperty1<out Any, Any?>.typeName()=this.returnType.toString().substringAfterLast(".")


