package me.inassar.koindependencyinjection.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel:ViewModel() {
    abstract fun provideState():BaseState
}