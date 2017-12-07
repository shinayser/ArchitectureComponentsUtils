package com.shinayser.ac.utils.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData

inline fun <T> LiveData<T>.observe(lifecycleOwner: LifecycleOwner, crossinline observer: (T?) -> Unit) {
    this.observe(lifecycleOwner, android.arch.lifecycle.Observer { value -> observer.invoke(value) })
}