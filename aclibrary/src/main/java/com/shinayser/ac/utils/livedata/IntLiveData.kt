package com.shinayser.ac.utils.livedata

/**
A live data for integer values.
 */
open class IntLiveData() : DefaultLiveData<Int>() {

    init {
        value = 0
    }

    constructor(defaultValue: Int) : this() {
        this.value = defaultValue
    }

    @JvmOverloads
    fun increment(amount: Int = 1): Int {
        this.value = value + amount
        return this.value
    }

    @JvmOverloads
    fun decrement(amount: Int = 1): Int {
        this.value = value - amount
        return this.value
    }

    fun multiply(amount: Int): Int {
        this.value = value * amount
        return this.value
    }

    fun divide(amount: Int): Int {
        this.value = value / amount
        return this.value
    }

}
