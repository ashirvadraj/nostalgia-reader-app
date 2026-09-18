package com.nostalgia.reader.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nostalgia.reader.R
import com.nostalgia.reader.databinding.ItemPublicationCardBinding
import com.nostalgia.reader.model.Publication

class PublicationAdapter(
    private val context: Context,
    private var items: List<Publication>,
    private val onItemClick: (Publication) -> Unit
) : RecyclerView.Adapter<PublicationAdapter.ViewHolder>() {

    fun updateData(newItems: List<Publication>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPublicationCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemPublicationCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Publication) {
            binding.tvTitle.text = item.title
            binding.tvTag.text = item.series
            binding.tvSubInfo.text = "${item.year} • ${item.pageCount} पृष्ठ"

            // Tag color accent based on category
            val tagColor = when (item.category) {
                "MAGAZINE" -> ContextCompat.getColor(context, R.color.tag_champak)
                "COMIC" -> ContextCompat.getColor(context, R.color.tag_comics)
                "NEWSPAPER" -> ContextCompat.getColor(context, R.color.tag_newspaper)
                else -> ContextCompat.getColor(context, R.color.primary)
            }
            binding.tvTag.setBackgroundColor(tagColor)

            // Load Cover with fallback placeholder
            Glide.with(context)
                .load(item.coverUrl)
                .placeholder(R.drawable.ic_book)
                .error(R.drawable.ic_book)
                .centerCrop()
                .into(binding.imgCover)

            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}
