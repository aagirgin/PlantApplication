package com.example.hubxapplication.presentation.paywall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.hubxapplication.R
import com.example.hubxapplication.databinding.FragmentOnBoardingBinding
import com.example.hubxapplication.databinding.FragmentPaywallBinding
import com.example.hubxapplication.presentation.onboarding.OnBoardingViewModel
import com.example.hubxapplication.presentation.paywall.adapter.PaywallRcAdapter
import com.example.hubxapplication.presentation.paywall.model.PaywallRcUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaywallFragment : Fragment() {
    private lateinit var binding: FragmentPaywallBinding
    private lateinit var paywallRcAdapter: PaywallRcAdapter
    private val viewModel by viewModels<PaywallViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout first
        binding = FragmentPaywallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUi()
    }

    private fun bindUi(){
        with(binding){
            button.setOnClickListener {
                findNavController().navigate(R.id.action_paywallFragment_to_homeFragment)
            }
            paywallRcAdapter = PaywallRcAdapter(viewModel.getData())
            paywallRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            paywallRecyclerView.adapter = paywallRcAdapter
        }
    }
}