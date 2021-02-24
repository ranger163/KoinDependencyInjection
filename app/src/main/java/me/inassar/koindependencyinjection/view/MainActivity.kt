package me.inassar.koindependencyinjection.view

import me.inassar.koindependencyinjection.R
import me.inassar.koindependencyinjection.base.BaseActivity
import me.inassar.koindependencyinjection.databinding.MainActivityBinding
import me.inassar.koindependencyinjection.snack
import org.koin.android.ext.android.inject

class MainActivity :
    BaseActivity<MainActivityBinding, MainActivityState, MainActivityViewModel>
        (R.layout.activity_main) {

    override val viewModel: MainActivityViewModel by inject()

    override fun observeViewState(state: MainActivityState) {
        // Observe the STATE here as this will handle API response
        // API SUCCESS, FAILURE and LOADING

        state.loginValidationState.observe(this, { loginState ->
            when (loginState) {
                is ValidateLoginState.UsernameEmpty -> {
                    clearErrors()
                    bindingViews().usernameEt.error = "Please enter username"
                }
                is ValidateLoginState.PasswordEmpty -> {
                    clearErrors()
                    bindingViews().passwordEt.error = "Please enter password"
                }
                is ValidateLoginState.Success -> {
                    clearErrors()
                    bindingViews().loginBtn.snack("Hooray, successful login")
                }
            }
        })
    }

    private fun clearErrors() {
        bindingViews().usernameEt.error = null
        bindingViews().passwordEt.error = null
    }

}