package com.example.hubxapplication.presentation.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hubxapplication.R
import com.example.hubxapplication.domain.model.Questions

class QuestionAdapter(
    private var questionList: List<Questions>,
    private val onItemClick: (Questions) -> Unit
) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.view_pager_image)
        private val titleTextView: TextView = itemView.findViewById(R.id.card_txt)

        fun bind(question: Questions) {
            titleTextView.text = question.title
            Glide.with(itemView.context)
                .load(question.imageUrl)
                .into(imageView)
            itemView.setOnClickListener {
                onItemClick(question)  // Trigger the callback when item is clicked
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_horizontal_recycler_view_item, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(questionList[position])
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

}