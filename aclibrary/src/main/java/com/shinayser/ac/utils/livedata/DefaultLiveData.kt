package com.shinayser.ac.utils.livedata

import android.arch.lifecycle.MutableLiveData

/**
 *  A live data that can receive a default value on it's constructor.
 */
open class DefaultLiveData<T>() : MutableLiveData<T>() {

    constructor(defaultValue: T) : this() {
        this.value = defaultValue
    }

    override fun getValue(): T {
        return super.getValue()!!
    }


    /**
     * Sets the value of this live data to the return of the "block" parameter.
     *
     * WARNING: if calling it from JAVA instead of Kotlin, be aware that the primitive live datas (IntLiveData, DoubleLiveData, FloatLiveData, LongLiveData, BooleanLiveData)
     * cannot be assign to null, so, never return null from the block function.
     */
    open fun modify(block: (T) -> T): T {
        this.value = block(this.value)
        return this.value
    }

    open fun alter(block: T.() -> Unit): Unit {
        this.value.block()
        this.value = this.value
    }

}