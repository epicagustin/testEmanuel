package com.emanuel.testsessionemanuel.features.home

import android.os.Bundle
import android.view.View
import com.emanuel.testsessionemanuel.base.BaseBindingFragment
import com.emanuel.testsessionemanuel.databinding.FragmentHomeBinding
import models.ProductModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseBindingFragment() {
    private val mViewModel by viewModel<HomeViewModel>()
    private val mBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater).apply {
            this.lifecycleOwner = this@HomeFragment
        }
    }

    override fun getViewResource(): View = mBinding.root
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getProducts()
        setObserver()
    }

    private fun setObserver() {
        mViewModel.products.observe(viewLifecycleOwner) {
            createListScreen(it)
        }
    }

    fun createListScreen(products: List<ProductModel>) {
        mBinding.rvProducts.adapter = ProductsAdapter.createAdapter(products)
    }

}