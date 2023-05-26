package com.alican.mvvm_starter.ui.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alican.mvvm_starter.R
import com.alican.mvvm_starter.base.BaseFragment
import com.alican.mvvm_starter.databinding.FragmentMapBinding

class MapFragment:BaseFragment<FragmentMapBinding>() {
    private val viewModel by viewModels<MapViewModel>()
    override fun getLayoutId(): Int  = R.layout.fragment_map

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}