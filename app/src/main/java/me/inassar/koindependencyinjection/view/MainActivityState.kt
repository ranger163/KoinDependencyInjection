package me.inassar.koindependencyinjection.view

import androidx.lifecycle.MutableLiveData
import me.inassar.koindependencyinjection.base.BaseState

class MainActivityState : BaseState {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginValidationState = MutableLiveData<ValidateLoginState>()

}

sealed class ValidateLoginState {
    object EmailEmpty : ValidateLoginState()
    object PasswordEmpty : ValidateLoginState()
}
