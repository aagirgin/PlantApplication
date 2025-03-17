package com.example.hubxapplication.presentation.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.hubxapplication.R
import com.example.hubxapplication.databinding.FragmentOnBoardingBinding
import com.example.hubxapplication.presentation.onboarding.adapter.OnboardingAdapter
import com.example.hubxapplication.presentation.onboarding.state.OnboardingUiState
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private val viewModel by viewModels<OnBoardingViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        bindUi()
        return binding.root
    }

    private fun bindUi() {
        with(binding) {
            binding.button.setOnClickListener {
                findNavController().navigate(R.id.action_onBoardingFragment_to_paywallFragment)
            }
            binding.viewPager.adapter = OnboardingAdapter(viewModel.getData())
            TabLayoutMediator(
                binding.intoTabLayout,
                binding.viewPager
            ) { tab, position ->
                // You can customize your TabLayout if needed
            }.attach()
        }
    }

}