package me.inassar.koindependencyinjection.di

import me.inassar.koindependencyinjection.view.MainActivityViewModel
import org.koin.dsl.module

val viewModelModule = module { factory { MainActivityViewModel(get()) } }