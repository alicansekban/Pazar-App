package com.alican.mvvm_starter.ui.home.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alican.mvvm_starter.R
import com.alican.mvvm_starter.base.BaseFragment
import com.alican.mvvm_starter.databinding.FragmentProductDetailBinding

class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_product_detail
    private val viewModel: ProductDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}