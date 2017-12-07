package com.shinayser.ac.utils.livedata

/**
A live data for Long values.
 */
open class LongLiveData() : DefaultLiveData<Long>() {

    init {
        value = 0L
    }

    constructor(defaultValue: Long) : this() {
        this.value = defaultValue
    }

    @JvmOverloads
    fun increment(amount: Long = 1L): Long {
        this.value = value + amount
        return this.value
    }

    @JvmOverloads
    fun decrement(amount: Long = 1L): Long {
        this.value = value - amount
        return this.value
    }

    fun multiply(amount: Long): Long {
        this.value = value * amount
        return this.value
    }

    fun divide(amount: Long): Long {
        this.value = value / amount
        return this.value
    }

}