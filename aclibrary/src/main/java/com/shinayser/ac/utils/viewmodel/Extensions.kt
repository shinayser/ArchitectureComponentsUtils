package com.shinayser.ac.utils.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Created by denox on 11/12/2017.
 */
inline fun <reified T : ViewModel> Fragment.getViewModel() = ViewModelProviders.of(this).get(T::class.java)
inline fun <reified T : ViewModel> FragmentActivity.getViewModel() = ViewModelProviders.of(this).get(T::class.java)

inline fun <T> MutableLiveData<T>.setValueTo(block: (T?) -> T) {
    this.value = block(this.value)
}

inline fun <T> MutableLiveData<T>.modify(block: T.() -> Unit) {
    this.value?.block()
    this.value = this.value
}