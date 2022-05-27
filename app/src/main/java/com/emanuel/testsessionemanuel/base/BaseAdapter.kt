package com.emanuel.testsessionemanuel.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BaseAdapter<T> : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<T>>() {

    var listOfItems: MutableList<T> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    lateinit var invokeViewHolderBinding: ((T, ViewBinding) -> Unit)
    lateinit var invokeOnCreateViewHolder: ((ViewGroup) -> ViewBinding)

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(listOfItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return BaseViewHolder(invokeOnCreateViewHolder(parent), invokeViewHolderBinding)
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

    class BaseViewHolder<in T> internal constructor(
        private val binding: ViewBinding,
        private val invoke: (T, ViewBinding) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T) {
            invoke(item, binding)
        }
    }
}
