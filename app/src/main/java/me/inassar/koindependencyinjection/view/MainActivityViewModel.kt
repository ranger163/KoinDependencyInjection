package me.inassar.koindependencyinjection.view

import me.inassar.koindependencyinjection.base.BaseState
import me.inassar.koindependencyinjection.base.BaseViewModel

class MainActivityViewModel(private val state: MainActivityState):BaseViewModel() {
    override fun provideState(): BaseState =state
}