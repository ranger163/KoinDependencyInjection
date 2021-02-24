package me.inassar.koindependencyinjection.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import me.inassar.koindependencyinjection.BR

abstract class BaseActivity<BINDING : ViewDataBinding, STATE : BaseState, VIEWMODEL : BaseViewModel>
    (@LayoutRes val layoutId: Int) : AppCompatActivity() {

    protected abstract val viewModel: VIEWMODEL
    protected val state: STATE by lazy {
        viewModel.provideState() as STATE
    }
    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        initView()
        initDataBinding()
        observeViewState(state) // Call ObserveViewState
    }

    open fun initView() {
        TODO("Not yet implemented")
    }

    open fun initDataBinding() {
        DataBindingUtil.setContentView<BINDING>(this, layoutId)
            .apply {
                binding = this
                lifecycleOwner = this@BaseActivity
                setVariable(BR.viewModel,viewModel)
                setVariable(BR.state,state)
                executePendingBindings()
            }
    }

    abstract fun observeViewState(state: STATE)
}