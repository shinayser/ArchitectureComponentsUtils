package com.shinayser.ac.utils.livedata

/**
A live data for Double values.
 */
open class DoubleLiveData() : DefaultLiveData<Double>() {

    init {
        value = 0.0
    }

    constructor(defaultValue: Double) : this() {
        this.value = defaultValue
    }

    @JvmOverloads
    fun increment(amount: Double = 1.0): Double {
        this.value = value + amount
        return this.value
    }

    @JvmOverloads
    fun decrement(amount: Double = 1.0): Double {
        this.value = value - amount
        return this.value
    }

    fun multiply(amount: Double): Double {
        this.value = value * amount
        return this.value
    }

    fun divide(amount: Double): Double {
        this.value = value / amount
        return this.value
    }

}
