package com.shinayser.ac.utils.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

inline fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, crossinline observer: (T?) -> Unit) {
	this.observe(lifecycleOwner, android.arch.lifecycle.Observer { value -> observer.invoke(value) })
}


inline fun <T> MutableLiveData<T>.setValueTo(block: (T?) -> T) {
	this.value = block(this.value)
}

inline fun <T> MutableLiveData<T>.modify(block: T.() -> Unit) {
	this.value?.block()
	this.value = this.value
}

inline fun <T> MutableLiveData<T>.postValueTo(block: (T?) -> T) {
	this.postValue(block(this.value))
}

inline fun <T> MutableLiveData<T>.postModify(block: T.() -> Unit) {
	this.value?.block()
	this.postValue(this.value)
}

operator fun <T> MutableLiveData<T>.invoke(value: T, post: Boolean = false) {
	if (!post)
		setValue(value)
	else
		postValue(value)
}

inline operator fun <T, R> MutableLiveData<T>.invoke(lambda: T?.() -> R): R = value.lambda()

inline operator fun <T, R> DefaultLiveData<T>.invoke(lambda: T.() -> R): R = value.lambda()

operator fun <T> MutableLiveData<T>.invoke() = this.value
operator fun <T> DefaultLiveData<T>.invoke() = this.value
