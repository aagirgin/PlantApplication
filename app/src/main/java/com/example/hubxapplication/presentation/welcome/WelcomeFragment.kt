package com.example.hubxapplication.presentation.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.hubxapplication.R
import com.example.hubxapplication.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        bindUi()
        return binding.root
    }

    private fun bindUi() {
        with(binding) {
            button.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_onBoardingFragment)
            }
        }
    }
}