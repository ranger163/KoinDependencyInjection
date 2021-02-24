package me.inassar.koindependencyinjection.view

import me.inassar.koindependencyinjection.base.BaseState
import me.inassar.koindependencyinjection.base.BaseViewModel

class MainActivityViewModel(private val state: MainActivityState) : BaseViewModel() {
    override fun provideState(): BaseState = state

    fun login() {
        if (!validUserInfo()) {
            return
        }
    }

    private fun validUserInfo(): Boolean {
        return when {
            state.username.value.isNullOrEmpty() -> {
                state.loginValidationState.value = ValidateLoginState.UsernameEmpty
                false
            }
            state.password.value.isNullOrEmpty() -> {
                state.loginValidationState.value = ValidateLoginState.PasswordEmpty
                false
            }
            else -> {
                state.loginValidationState.value = ValidateLoginState.Success
                true
            }
        }
    }
}