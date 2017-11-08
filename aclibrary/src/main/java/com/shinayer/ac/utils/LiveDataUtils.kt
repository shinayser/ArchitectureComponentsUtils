package com.shinayer.ac.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

/**
 * Created by denox on 08/11/2017.
 */
open class DefaultLiveData<T>() : MutableLiveData<T>() {

    constructor(defaultValue: T) : this() {
        this.value = defaultValue
    }

    override fun getValue(): T {
        return super.getValue()!!
    }


    inline fun modify( block: (T) -> T ){
        this.value = block(this.value)
    }

}

//Integer///////////////////////////////////////////////////////////////////////////////////////////
open class IntLiveData() : DefaultLiveData<Int>() {

    init {
        value = 0
    }

    constructor(defaultValue: Int) : this() {
        this.value = defaultValue
    }

    fun increment(amount: Int = 1) {
        this.value = value + amount
    }

    fun decrement(amount: Int = 1) {
        this.value = value - amount
    }

    fun multiply(amount: Int) {
        this.value = value * amount
    }

    fun divide(amount: Int) {
        this.value = value / amount
    }

}

//Double////////////////////////////////////////////////////////////////////////////////////////////
open class DoubleLiveData() : DefaultLiveData<Double>() {

    init {
        value = 0.0
    }
    constructor(defaultValue: Double) : this() {
        this.value = defaultValue
    }

    fun increment(amount: Double = 1.0) {
        this.value = value + amount
    }

    fun decrement(amount: Double = 1.0) {
        this.value = value - amount
    }

    fun multiply(amount: Double) {
        this.value = value * amount
    }

    fun divide(amount: Double) {
        this.value = value / amount
    }

}

//Long//////////////////////////////////////////////////////////////////////////////////////////////
open class LongLiveData() : DefaultLiveData<Long>() {

    init {
        value = 0L
    }

    constructor(defaultValue: Long) : this() {
        this.value = defaultValue
    }

    fun increment(amount: Long = 1L) {
        this.value = value + amount
    }

    fun decrement(amount: Long = 1L) {
        this.value = value - amount
    }

    fun multiply(amount: Long) {
        this.value = value * amount
    }

    fun divide(amount: Long) {
        this.value = value / amount
    }

}


//Extensions////////////////////////////////////////////////////////////////////////////////////////
inline fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, crossinline observer: (T?) -> Unit) {
    this.observe(lifecycleOwner, android.arch.lifecycle.Observer { value -> observer.invoke(value) })
}