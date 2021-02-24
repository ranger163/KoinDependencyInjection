package me.inassar.koindependencyinjection.di

import me.inassar.koindependencyinjection.view.MainActivityState
import org.koin.dsl.module

val stateModule = module {
    factory { MainActivityState() }
}