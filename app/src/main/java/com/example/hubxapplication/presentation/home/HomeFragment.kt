package com.example.hubxapplication.presentation.home

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hubxapplication.R
import com.example.hubxapplication.databinding.FragmentHomeBinding
import com.example.hubxapplication.domain.model.Categories
import com.example.hubxapplication.domain.model.Questions
import com.example.hubxapplication.presentation.home.adapter.CategoriesAdapter
import com.example.hubxapplication.presentation.home.adapter.QuestionAdapter
import com.example.hubxapplication.presentation.home.state.CategoriesUiState
import com.example.hubxapplication.presentation.home.state.QuestionsUiState
import com.facebook.shimmer.ShimmerFrameLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initializeListeners()
        observeViewModel()
        return binding.root
    }

    private fun initializeListeners(){
        binding.mailConstBtn.setOnClickListener{
            requireContext().showToast("Mail Button Pressed!")
        }
    }

    private fun observeViewModel() {
        val questionsShimmer = binding.shimmerLayout
        val categoriesShimmer = binding.shimmerLayout2

        lifecycleScope.launch {
            launch {
                viewModel.questionsUiState.collect { state ->
                    when (state) {
                        is QuestionsUiState.Error -> {
                            //TODO HANDLE ERROR HERE
                        }

                        QuestionsUiState.Loading -> {
                            shimmerVisible(true, questionsShimmer)
                        }
                        is QuestionsUiState.Success -> {
                            shimmerVisible(false, questionsShimmer)
                            binding.questionRcView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
                            bindHorizontalRCView(state.data)
                        }
                    }
                }
            }

            launch {

                viewModel.categoriesUiState.collect { state ->
                    when (state) {
                        is CategoriesUiState.Error -> {
                            //TODO HANDLE ERROR HERE
                        }

                        CategoriesUiState.Loading -> {
                            shimmerVisible(true , categoriesShimmer)
                        }
                        is CategoriesUiState.Success -> {
                            shimmerVisible(false , categoriesShimmer)
                            binding.categoriesRcView.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
                            bindCategoriesData(state.data)
                        }
                    }
                }
            }
        }
    }


    private fun bindHorizontalRCView(questionList: List<Questions>) {
        val adapter = QuestionAdapter(questionList){ clickedItem ->
            val message = "Item id: ${clickedItem.id}!"
            requireContext().showToast(message)
        }
        binding.questionRcView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.questionRcView.adapter = adapter
        binding.questionRcView.visibility = View.VISIBLE
    }

    private fun bindCategoriesData(categories: Categories) {
        val adapter = CategoriesAdapter(categories.data){ clickedItem ->
            val message = "Item id: ${clickedItem.id}! Name: ${clickedItem.name}!"
            requireContext().showToast(message)
        }
        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.categoriesRcView.layoutManager = gridLayoutManager
        binding.categoriesRcView.adapter = adapter
        binding.categoriesRcView.visibility = View.VISIBLE
    }

    private fun shimmerVisible(bool: Boolean, layout: ShimmerFrameLayout) {
        if (bool) {
            layout.startShimmer()
        } else {
            layout.hideShimmer()
        }
    }
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}