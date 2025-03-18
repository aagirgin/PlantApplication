package com.example.hubxapplication.presentation.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import com.example.hubxapplication.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflater.inflate(R.layout.fragment_splash, container, false)
        bindViewModel()
        return binding
    }

    private fun bindViewModel(){
        viewLifecycleOwner.lifecycleScope.launch {
            delay(1000L)
            splashViewModel.onboardingStatus.collect { status ->
                when(status){
                    true -> navigateToMainScreen()
                    false -> navigateToOnboardingScreen()
                    else -> {}
                }
            }
        }

    }

    private fun navigateToMainScreen() {
        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
    }

    private fun navigateToOnboardingScreen() {
        findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
    }
}