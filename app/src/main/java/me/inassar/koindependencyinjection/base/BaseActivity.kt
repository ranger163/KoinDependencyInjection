package me.inassar.koindependencyinjection.base

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.inassar.koindependencyinjection.BR

abstract class BaseActivity<BINDING : ViewDataBinding, STATE : BaseState, VIEWMODEL : BaseViewModel>
    (@LayoutRes val layoutId: Int) : AppCompatActivity() {

    protected abstract val viewModel: VIEWMODEL
    private val state: STATE by lazy {
        viewModel.provideState() as STATE
    }
    private lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        initView()
        initDataBinding()
        observeViewState(state) // Call ObserveViewState
    }

    open fun initView() {
    }

    open fun initDataBinding() {
        DataBindingUtil.setContentView<BINDING>(this, layoutId)
            .apply {
                binding = this
                lifecycleOwner = this@BaseActivity
                setVariable(BR.viewModel, viewModel)
                setVariable(BR.state, state)
                executePendingBindings()
            }
    }

    protected fun bindingViews(): BINDING = binding

    abstract fun observeViewState(state: STATE)

}