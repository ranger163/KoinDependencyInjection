package me.inassar.koindependencyinjection.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

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
    }

    open fun initView() {
        TODO("Not yet implemented")
    }

    open fun initDataBinding() {
        DataBindingUtil.setContentView<BINDING>(this, layoutId)
            .apply {
                binding = this
                lifecycleOwner = this@BaseActivity
                executePendingBindings()
            }
    }

    abstract fun observeViewState(state: STATE)
}