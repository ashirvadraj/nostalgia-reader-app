package com.nostalgia.reader.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
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
    private var isEpaperMode = false

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
        setupEpaperWebView(publication!!)
    }

    private fun setupReader(pub: Publication) {
        val currentTheme = prefsManager.getReadingTheme()
        pagerAdapter = ReaderPagerAdapter(this, pub.pages, currentTheme)
        binding.viewPagerReader.adapter = pagerAdapter

        binding.tvReaderTitle.text = pub.title

        val totalPages = pub.pages.size
        binding.seekBarPages.max = totalPages - 1

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

        binding.viewPagerReader.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updatePageIndicator(position, totalPages)
                binding.seekBarPages.progress = position

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

        binding.btnPrevPage.setOnClickListener {
            val curr = binding.viewPagerReader.currentItem
            if (curr > 0) binding.viewPagerReader.currentItem = curr - 1
        }

        binding.btnNextPage.setOnClickListener {
            val curr = binding.viewPagerReader.currentItem
            if (curr < totalPages - 1) binding.viewPagerReader.currentItem = curr + 1
        }

        binding.seekBarPages.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    binding.viewPagerReader.currentItem = progress
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.btnReaderBack.setOnClickListener {
            if (isEpaperMode && binding.webViewEpaper.canGoBack()) {
                binding.webViewEpaper.goBack()
            } else {
                finish()
            }
        }

        binding.btnThemeToggle.setOnClickListener {
            cycleTheme()
        }

        binding.btnReaderBookmark.setOnClickListener {
            val currPage = binding.viewPagerReader.currentItem + 1
            Toast.makeText(this, "पृष्ठ $currPage बुकमार्क किया गया", Toast.LENGTH_SHORT).show()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupEpaperWebView(pub: Publication) {
        if (!pub.epaperUrl.isNullOrBlank()) {
            binding.btnToggleEpaper.visibility = View.VISIBLE

            val webSettings = binding.webViewEpaper.settings
            webSettings.javaScriptEnabled = true
            webSettings.domStorageEnabled = true
            webSettings.builtInZoomControls = true
            webSettings.displayZoomControls = false
            webSettings.useWideViewPort = true
            webSettings.loadWithOverviewMode = true
            webSettings.cacheMode = WebSettings.LOAD_DEFAULT

            binding.webViewEpaper.webViewClient = object : WebViewClient() {}
            binding.webViewEpaper.webChromeClient = object : WebChromeClient() {}

            binding.btnToggleEpaper.setOnClickListener {
                toggleEpaperMode(pub.epaperUrl)
            }
        } else {
            binding.btnToggleEpaper.visibility = View.GONE
        }
    }

    private fun toggleEpaperMode(url: String) {
        isEpaperMode = !isEpaperMode
        if (isEpaperMode) {
            binding.viewPagerReader.visibility = View.GONE
            binding.webViewEpaper.visibility = View.VISIBLE
            binding.toolbarBottom.visibility = View.GONE
            binding.webViewEpaper.loadUrl(url)
            Toast.makeText(this, "लाइव ई-अखबार (Official ePaper) लोड हो रहा है...", Toast.LENGTH_SHORT).show()
        } else {
            binding.webViewEpaper.visibility = View.GONE
            binding.viewPagerReader.visibility = View.VISIBLE
            binding.toolbarBottom.visibility = View.VISIBLE
            Toast.makeText(this, "डिजिटल रीडर मोड (Digital Reader Mode)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updatePageIndicator(page: Int, total: Int) {
        val pub = publication
        val section = if (pub != null && page < pub.pages.size && !pub.pages[page].sectionName.isNullOrBlank()) {
            " • ${pub.pages[page].sectionName}"
        } else ""
        binding.tvReaderPageIndicator.text = "पृष्ठ ${page + 1} / $total$section"
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
