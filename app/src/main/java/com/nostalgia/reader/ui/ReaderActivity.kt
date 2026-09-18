package com.nostalgia.reader.ui

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.nostalgia.reader.R
import com.nostalgia.reader.data.PreferencesManager
import com.nostalgia.reader.databinding.ActivityReaderBinding
import com.nostalgia.reader.model.Publication
import com.nostalgia.reader.model.ReadingProgress
import com.nostalgia.reader.ui.adapter.ReaderPagerAdapter

class ReaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReaderBinding
    private lateinit var prefsManager: PreferencesManager
    private lateinit var pagerAdapter: ReaderPagerAdapter
    private var publication: Publication? = null
    private var isControlsVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefsManager = PreferencesManager(this)
        publication = intent.getSerializableExtra(EXTRA_PUBLICATION) as? Publication

        if (publication == null || publication!!.pages.isEmpty()) {
            Toast.makeText(this, "पृष्ठ सामग्री उपलब्ध नहीं है", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        setupReader(publication!!)
    }

    private fun setupReader(pub: Publication) {
        val currentTheme = prefsManager.getReadingTheme()
        pagerAdapter = ReaderPagerAdapter(this, pub.pages, currentTheme)
        binding.viewPagerReader.adapter = pagerAdapter

        binding.tvReaderTitle.text = pub.title

        // Setup Page Indicator & SeekBar
        val totalPages = pub.pages.size
        binding.seekBarPages.max = totalPages - 1

        // Restore start page if saved or passed
        val savedProgress = prefsManager.getReadingProgress(pub.id)
        val passedStartPage = intent.getIntExtra(EXTRA_START_PAGE, -1)
        val initialPage = when {
            passedStartPage in 0 until totalPages -> passedStartPage
            savedProgress != null && savedProgress.lastReadPage in 0 until totalPages -> savedProgress.lastReadPage
            else -> 0
        }

        binding.viewPagerReader.setCurrentItem(initialPage, false)
        updatePageIndicator(initialPage, totalPages)
        binding.seekBarPages.progress = initialPage

        // Page change callback
        binding.viewPagerReader.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updatePageIndicator(position, totalPages)
                binding.seekBarPages.progress = position

                // Save reading progress auto-bookmark
                val progress = ReadingProgress(
                    publicationId = pub.id,
                    title = pub.title,
                    lastReadPage = position,
                    totalPages = totalPages,
                    lastReadTimestamp = System.currentTimeMillis(),
                    readingTheme = prefsManager.getReadingTheme()
                )
                prefsManager.saveReadingProgress(progress)
            }
        })

        // Prev / Next Page Buttons
        binding.btnPrevPage.setOnClickListener {
            val curr = binding.viewPagerReader.currentItem
            if (curr > 0) binding.viewPagerReader.currentItem = curr - 1
        }

        binding.btnNextPage.setOnClickListener {
            val curr = binding.viewPagerReader.currentItem
            if (curr < totalPages - 1) binding.viewPagerReader.currentItem = curr + 1
        }

        // SeekBar change
        binding.seekBarPages.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    binding.viewPagerReader.currentItem = progress
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Back button
        binding.btnReaderBack.setOnClickListener {
            finish()
        }

        // Theme Toggle (Parchment -> Sepia -> Night -> Parchment)
        binding.btnThemeToggle.setOnClickListener {
            cycleTheme()
        }

        // Bookmark Toggle
        binding.btnReaderBookmark.setOnClickListener {
            val currPage = binding.viewPagerReader.currentItem + 1
            Toast.makeText(this, "पृष्ठ $currPage बुकमार्क किया गया", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updatePageIndicator(page: Int, total: Int) {
        binding.tvReaderPageIndicator.text = "पृष्ठ ${page + 1} / $total"
    }

    private fun cycleTheme() {
        val current = prefsManager.getReadingTheme()
        val next = when (current) {
            "PARCHMENT" -> "SEPIA"
            "SEPIA" -> "NIGHT"
            else -> "PARCHMENT"
        }
        prefsManager.setReadingTheme(next)
        pagerAdapter.setTheme(next)

        val themeLabel = when (next) {
            "SEPIA" -> "सीपिया मोड (Sepia)"
            "NIGHT" -> "नाइट मोड (Night)"
            else -> "कागज़ मोड (Parchment)"
        }
        Toast.makeText(this, "थीम: $themeLabel", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_PUBLICATION = "extra_publication"
        const val EXTRA_START_PAGE = "extra_start_page"
    }
}
