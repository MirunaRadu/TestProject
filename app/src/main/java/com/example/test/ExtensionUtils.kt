package com.example.test

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.observeNonNull(lifecycleOwner: LifecycleOwner, action: (T) -> Unit) =
    observe(lifecycleOwner, Observer { it?.let(action) })
