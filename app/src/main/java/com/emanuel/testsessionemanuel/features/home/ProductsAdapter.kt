package com.emanuel.testsessionemanuel.features.home

import android.view.LayoutInflater
import com.emanuel.testsessionemanuel.base.BaseAdapter
import com.emanuel.testsessionemanuel.databinding.ItmsProductsBinding
import models.ProductModel

object ProductsAdapter {
    fun createAdapter(productsList: List<ProductModel>): BaseAdapter<ProductModel> {
        return BaseAdapter<ProductModel>().apply {
            listOfItems = productsList.toMutableList()
            invokeViewHolderBinding = {eachItem, viewBinding ->
                val view = viewBinding as ItmsProductsBinding
                with(view) {
                    productTitle.text = eachItem.name
                    productDetail.text = eachItem.detail
                }
            }
            invokeOnCreateViewHolder = { viewGroup ->
                ItmsProductsBinding.inflate(
                    LayoutInflater.from(viewGroup.context), viewGroup, false
                )
            }
        }
    }

    /*fun createAdapter(
        listCheckout: List<CheckoutModel>,
        invoker: (CheckoutModel) -> Unit
    ): BaseAdapter<CheckoutModel> {

        return BaseAdapter<CheckoutModel>().apply {
            listOfItems = listCheckout.toMutableList()
            invokeViewHolderBinding = { eachItem, viewBinding ->
                val view = viewBinding as ItemQrRegistredBinding
                with(view) {
                    rootQrRegistred.setOnClickListener {
                        invoker.invoke(eachItem)
                    }
                    txtNameQr.text = eachItem.name?.capitalizeWords()
                }
            }
            invokeOnCreateViewHolder = { viewGroup ->
                // Inflate the layout and send it to the adapter
                ItemQrRegistredBinding.inflate(
                    LayoutInflater.from(viewGroup.context), viewGroup, false
                )
            }
        }
    }
     */
}