package com.shinayer.ac.utils.livedata

/**
A live data for Double values.
 */
open class BooleanLiveData() : DefaultLiveData<Boolean>() {

    init {
        value = false
    }

    constructor(defaultValue: Boolean) : this() {
        this.value = defaultValue
    }

    /**
     * Invert the value os the boolean value.
     */
    fun invert(): Boolean {
        this.value = !value
        return this.value
    }

}