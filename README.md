# KoinDependencyInjection
Project lay hands on implementation of KOIN Dependency Injection

![Logo](/app/src/main/res/drawable/koin_logo.png)

Koin (https://insert-koin.io) is a pragmatic dependency injection framework for Kotlin/Android developers. 
This is a project to practice KOIN implementation using the power of Kotlin language.

According to the official documentation, we can start using Koin in three simple stages:
1) Declare a module : Defines those entities which will be injected at some point in the app. 
In the project, I've created two modules files - StateModule and ViewModelModule

2) Start Koin : A single line, startKoin(this, listOf(applicationModule)), allows you to launch the DI process and indicate which modules will be available when needed. Here in the prject, I've have declared it in the App application class.

3) Perform an injection: In consonance with Kotlin features, Koin allows to perform lazy injections in a very convenient way by using "by inject()" in the MainActivity class.
