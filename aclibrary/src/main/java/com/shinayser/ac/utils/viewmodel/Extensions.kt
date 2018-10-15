package com.shinayser.ac.utils.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Created by denox on 11/12/2017.
 */
inline fun <reified T : ViewModel> androidx.fragment.app.Fragment.getViewModel() = ViewModelProviders.of(this).get(T::class.java)

inline fun <reified T : ViewModel> androidx.fragment.app.FragmentActivity.getViewModel() = ViewModelProviders.of(this).get(T::class.java)
