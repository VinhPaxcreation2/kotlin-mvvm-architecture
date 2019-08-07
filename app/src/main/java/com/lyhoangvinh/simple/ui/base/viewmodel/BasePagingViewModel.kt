package com.lyhoangvinh.simple.ui.base.viewmodel

import androidx.annotation.CallSuper
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import com.lyhoangvinh.simple.data.entities.DataEmpty
import com.lyhoangvinh.simple.utils.SafeMutableLiveData


abstract class BasePagingViewModel<A : RecyclerView.Adapter<*>> : BaseViewModel() {

    @Nullable
    lateinit var adapter: A

    var isFistUiFetchData = false

    var dataEmptySafeMutableLiveData = SafeMutableLiveData<DataEmpty>()

    @CallSuper
    open fun initAdapter(@NonNull adapter: A) {
        this.adapter = adapter
    }

    /**
     * refreshUi All
     */
    @CallSuper
    fun refresh() {
        fetchData()
        isFistUiFetchData = true
    }

    protected abstract fun fetchData()

    /**
     *  update empty view
     */
    fun hideNoDataState(isEmpty: Boolean) {
        dataEmptySafeMutableLiveData.setValue(DataEmpty(isEmpty))
    }
}