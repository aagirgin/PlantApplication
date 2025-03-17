package com.example.hubxapplication.presentation.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hubxapplication.databinding.ViewPagerOnboardingItemBinding
import com.example.hubxapplication.presentation.onboarding.model.OnboardingUiModel


class OnboardingAdapter(private val item: List<OnboardingUiModel>) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {
    class ViewHolder(val binding: ViewPagerOnboardingItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ViewPagerOnboardingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val selected = item[position]
            binding.apply {
                tvIntroTitle.text = selected.title
                viewPagerImage.setImageResource(selected.img)
            }
        }
    }

    override fun getItemCount() = item.size
}