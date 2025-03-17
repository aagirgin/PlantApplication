package com.example.hubxapplication.presentation.home.adapter

import androidx.cardview.widget.CardView
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hubxapplication.R
import com.example.hubxapplication.domain.model.CategoriesData

class CategoriesAdapter(private var categoriesList: List<CategoriesData>, private val onItemClick: (CategoriesData) -> Unit) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_vertical_recycler_view_item, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categoriesList[position]
        holder.bind(category)
        holder.setCardViewHeight()
        holder.itemView.setOnClickListener {
            onItemClick(category)
        }
    }

    override fun getItemCount(): Int = categoriesList.size

    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.rc_item_txt)
        private val image: ImageView = itemView.findViewById(R.id.rc_img_item_view)
        private val cardView: CardView = itemView.findViewById(R.id.card_view)

        fun bind(category: CategoriesData) {
            title.text = category.title
            Glide.with(itemView.context)
                .load(category.image.url)
                .into(image)
        }

        fun setCardViewHeight() {
            cardView.viewTreeObserver.addOnGlobalLayoutListener {
                val width = cardView.width
                val layoutParams = cardView.layoutParams
                layoutParams.height = width
                cardView.layoutParams = layoutParams
            }
        }
    }
}
