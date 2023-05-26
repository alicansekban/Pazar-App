package com.alican.mvvm_starter.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.alican.mvvm_starter.R
import com.alican.mvvm_starter.base.BaseFragment
import com.alican.mvvm_starter.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    private val viewModel by viewModels<ProfileViewModel>()
    override fun getLayoutId(): Int  = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}