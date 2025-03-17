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
            onItemClick(category) // Trigger the callback when an item is clicked
        }
    }

    override fun getItemCount(): Int = categoriesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<CategoriesData>) {
        categoriesList = newList
        notifyDataSetChanged()
    }

    // ViewHolder class
    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.rc_item_txt)
        private val image: ImageView = itemView.findViewById(R.id.rc_img_item_view)
        private val cardView: CardView = itemView.findViewById(R.id.card_view)

        // Binding data to the views
        fun bind(category: CategoriesData) {
            title.text = category.title
            Glide.with(itemView.context)
                .load(category.image.url)
                .into(image)
        }

        // This function will dynamically set the height of the CardView to match its width
        fun setCardViewHeight() {
            // We use the viewTreeObserver to listen for layout changes and calculate width
            cardView.viewTreeObserver.addOnGlobalLayoutListener {
                val width = cardView.width

                // Calculate the layout params and set the height to be the same as width
                val layoutParams = cardView.layoutParams
                layoutParams.height = width
                cardView.layoutParams = layoutParams
            }
        }
    }
}
