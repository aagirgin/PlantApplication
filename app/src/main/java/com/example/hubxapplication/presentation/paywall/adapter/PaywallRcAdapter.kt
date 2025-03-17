package com.example.hubxapplication.presentation.paywall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hubxapplication.databinding.PaywallHorizontalRecyclerViewItemBinding
import com.example.hubxapplication.databinding.ViewPagerOnboardingItemBinding
import com.example.hubxapplication.presentation.paywall.model.PaywallRcUiModel


class PaywallRcAdapter(private val item: List<PaywallRcUiModel>) : RecyclerView.Adapter<PaywallRcAdapter.ViewHolder>() {
    class ViewHolder(val binding: PaywallHorizontalRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        PaywallHorizontalRecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val selected = item[position]
            binding.apply {
                binding.cardTitleTxt.text = selected.title
                binding.cardSubtitleTxt.text = selected.subTitle
                viewPagerImage.setImageResource(selected.img)
            }
        }
    }

    override fun getItemCount() = item.size
}