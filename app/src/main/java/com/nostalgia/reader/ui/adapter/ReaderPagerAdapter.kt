package com.nostalgia.reader.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nostalgia.reader.R
import com.nostalgia.reader.databinding.ItemReaderPageBinding
import com.nostalgia.reader.model.PageContent

class ReaderPagerAdapter(
    private val context: Context,
    private val pages: List<PageContent>,
    private var currentTheme: String = "PARCHMENT"
) : RecyclerView.Adapter<ReaderPagerAdapter.PageViewHolder>() {

    fun setTheme(theme: String) {
        currentTheme = theme
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val binding = ItemReaderPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.bind(pages[position])
    }

    override fun getItemCount(): Int = pages.size

    inner class PageViewHolder(private val binding: ItemReaderPageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(page: PageContent) {
            binding.tvPageNumberBadge.text = "पृष्ठ ${page.pageNumber}"
            binding.tvPageStoryHeader.text = page.storyTitle ?: ""
            binding.tvStoryContent.text = page.storyText ?: ""

            // Hide illustration card if no image, or show illustration placeholder
            if (page.imageUrl.isNullOrBlank()) {
                binding.cardIllustration.visibility = View.GONE
            } else {
                binding.cardIllustration.visibility = View.VISIBLE
            }

            // Apply reading theme colors
            when (currentTheme) {
                "SEPIA" -> {
                    val bg = ContextCompat.getColor(context, R.color.bg_sepia)
                    val text = ContextCompat.getColor(context, R.color.text_sepia)
                    binding.pageScrollView.setBackgroundColor(bg)
                    binding.tvStoryContent.setTextColor(text)
                    binding.tvPageStoryHeader.setTextColor(ContextCompat.getColor(context, R.color.primary_dark))
                }
                "NIGHT" -> {
                    val bg = ContextCompat.getColor(context, R.color.bg_true_black)
                    val text = ContextCompat.getColor(context, R.color.text_secondary)
                    binding.pageScrollView.setBackgroundColor(bg)
                    binding.tvStoryContent.setTextColor(text)
                    binding.tvPageStoryHeader.setTextColor(ContextCompat.getColor(context, R.color.accent))
                }
                else -> { // PARCHMENT
                    val bg = ContextCompat.getColor(context, R.color.bg_light_parchment)
                    val text = ContextCompat.getColor(context, R.color.text_dark)
                    binding.pageScrollView.setBackgroundColor(bg)
                    binding.tvStoryContent.setTextColor(text)
                    binding.tvPageStoryHeader.setTextColor(ContextCompat.getColor(context, R.color.primary))
                }
            }
        }
    }
}
