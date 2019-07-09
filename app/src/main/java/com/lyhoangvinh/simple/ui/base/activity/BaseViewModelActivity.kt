package com.lyhoangvinh.simple.ui.base.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import com.lyhoangvinh.simple.data.source.State
import com.lyhoangvinh.simple.data.source.Status
import com.lyhoangvinh.simple.ui.base.BaseViewModel
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
abstract class BaseViewModelActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @VisibleForTesting
    lateinit var binding: B

    lateinit var viewModel: VM

    abstract fun getLayoutResource(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResource())
        // noinspection unchecked
        val viewModelClass = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VM> // 1 is BaseViewModel
        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelClass]
        viewModel.onCreate(intent.extras)
        viewModel.stateLiveData.observe(this, Observer { handleState(it) })
    }

    /**
     * Default state handling, can be override
     * @param state viewModel's state
     */
    open fun handleState(state: State?) {
        setLoading(state != null && state.status == Status.LOADING)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroyView()
    }
}