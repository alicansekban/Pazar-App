package com.alican.mvvm_starter.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alican.mvvm_starter.R
import com.alican.mvvm_starter.base.BaseFragment
import com.alican.mvvm_starter.databinding.FragmentSearchBinding

class SearchFragment:BaseFragment<FragmentSearchBinding>() {
    private val viewModel by viewModels<SearchViewModel>()
    override fun getLayoutId(): Int  = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}