package com.shinayer.ac.utils.livedata

/**
A live data for Double values.
 */
open class FloatLiveData() : DefaultLiveData<Float>() {

    init {
        value = 0.0f
    }

    constructor(defaultValue: Float) : this() {
        this.value = defaultValue
    }

    @JvmOverloads
    fun increment(amount: Float = 1.0f) : Float {
        this.value = value + amount
        return this.value
    }

    @JvmOverloads
    fun decrement(amount: Float = 1.0f) : Float {
        this.value = value - amount
        return this.value
    }

    fun multiply(amount: Float) : Float {
        this.value = value * amount
        return this.value
    }

    fun divide(amount: Float) : Float {
        this.value = value / amount
        return this.value
    }

}