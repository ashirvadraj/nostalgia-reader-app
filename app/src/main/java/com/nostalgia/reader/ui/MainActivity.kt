package com.nostalgia.reader.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import com.nostalgia.reader.R
import com.nostalgia.reader.data.CatalogRepository
import com.nostalgia.reader.data.PreferencesManager
import com.nostalgia.reader.databinding.ActivityMainBinding
import com.nostalgia.reader.model.PageContent
import com.nostalgia.reader.model.Publication
import com.nostalgia.reader.reader.ArchiveIntegrator
import com.nostalgia.reader.ui.adapter.PublicationAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefsManager: PreferencesManager
    private lateinit var adapter: PublicationAdapter

    private var currentFilterType = "ALL" // ALL, CHAMPARK, NANDAN, COMICS, CHANDAMAMA, NEWSPAPER
    private var currentTab = 0 // 0: Home, 1: Favorites, 2: Offline

    private val openDocumentLauncher = registerForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let { handleImportedDocument(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefsManager = PreferencesManager(this)

        setupRecyclerView()
        setupSearch()
        setupCategoryChips()
        setupTabs()
        setupImportButton()
    }

    override fun onResume() {
        super.onResume()
        updateContinueReadingBanner()
        applyFilters()
    }

    private fun setupRecyclerView() {
        adapter = PublicationAdapter(this, emptyList()) { pub ->
            val intent = Intent(this, IssueDetailActivity::class.java).apply {
                putExtra(IssueDetailActivity.EXTRA_PUBLICATION_ID, pub.id)
            }
            startActivity(intent)
        }
        binding.rvCatalog.layoutManager = GridLayoutManager(this, 2)
        binding.rvCatalog.adapter = adapter
    }

    private fun setupSearch() {
        binding.etSearch.doAfterTextChanged { text ->
            val query = text?.toString().orEmpty()
            binding.btnClearSearch.visibility = if (query.isNotEmpty()) View.VISIBLE else View.GONE
            applyFilters()
        }

        binding.btnClearSearch.setOnClickListener {
            binding.etSearch.text?.clear()
        }
    }

    private fun setupCategoryChips() {
        val chips = listOf(
            binding.chipCatAll to "ALL",
            binding.chipCatChampak to "CHAMPAK",
            binding.chipCatNandan to "NANDAN",
            binding.chipCatComics to "COMICS",
            binding.chipCatChandamama to "CHANDAMAMA",
            binding.chipCatNewspaper to "NEWSPAPER"
        )

        chips.forEach { (chipView, type) ->
            chipView.setOnClickListener {
                currentFilterType = type
                updateChipSelections()
                applyFilters()
            }
        }
    }

    private fun updateChipSelections() {
        val chipMap = mapOf(
            "ALL" to binding.chipCatAll,
            "CHAMPAK" to binding.chipCatChampak,
            "NANDAN" to binding.chipCatNandan,
            "COMICS" to binding.chipCatComics,
            "CHANDAMAMA" to binding.chipCatChandamama,
            "NEWSPAPER" to binding.chipCatNewspaper
        )

        chipMap.forEach { (type, view) ->
            if (type == currentFilterType) {
                view.setBackgroundResource(R.drawable.bg_chip_selected)
                view.setTextColor(ContextCompat.getColor(this, R.color.text_primary))
            } else {
                view.setBackgroundResource(R.drawable.bg_chip)
                view.setTextColor(ContextCompat.getColor(this, R.color.text_secondary))
            }
        }
    }

    private fun setupTabs() {
        binding.tabHome.setOnClickListener {
            selectTab(0)
        }
        binding.tabFavorites.setOnClickListener {
            selectTab(1)
        }
        binding.tabOffline.setOnClickListener {
            selectTab(2)
        }
    }

    private fun selectTab(tabIndex: Int) {
        currentTab = tabIndex

        val activeColor = ContextCompat.getColor(this, R.color.primary)
        val inactiveColor = ContextCompat.getColor(this, R.color.text_muted)

        binding.imgTabHome.setColorFilter(if (tabIndex == 0) activeColor else inactiveColor)
        binding.tvTabHome.setTextColor(if (tabIndex == 0) activeColor else inactiveColor)

        binding.imgTabFav.setColorFilter(if (tabIndex == 1) activeColor else inactiveColor)
        binding.tvTabFav.setTextColor(if (tabIndex == 1) activeColor else inactiveColor)

        binding.imgTabOffline.setColorFilter(if (tabIndex == 2) activeColor else inactiveColor)
        binding.tvTabOffline.setTextColor(if (tabIndex == 2) activeColor else inactiveColor)

        applyFilters()
    }

    private fun setupImportButton() {
        binding.btnOpenFile.setOnClickListener {
            openDocumentLauncher.launch(
                arrayOf(
                    "application/pdf",
                    "application/zip",
                    "application/x-cbz",
                    "application/octet-stream"
                )
            )
        }
    }

    private fun handleImportedDocument(uri: Uri) {
        val fileName = uri.lastPathSegment ?: "स्थानीय पत्रिका"
        Toast.makeText(this, "फाइल खोली जा रही है: $fileName", Toast.LENGTH_SHORT).show()
        // Create dynamic local publication
        val localPub = Publication(
            id = "local_${System.currentTimeMillis()}",
            title = fileName,
            category = "COMIC",
            series = "स्थानीय फाइल (Local)",
            year = 2000,
            language = "hi",
            coverUrl = "",
            description = "आपके डिवाइस से चुनी गई स्थानीय पत्रिका/कॉमिक।",
            pageCount = 3,
            pages = listOf(
                PageContent(1, null, "पृष्ठ 1", "स्थानीय दस्तावेज प्रस्तुतकर्ता।"),
                PageContent(2, null, "पृष्ठ 2", "सामग्री लोड हो रही है..."),
                PageContent(3, null, "पृष्ठ 3", "समाप्त।")
            )
        )
        val intent = Intent(this, ReaderActivity::class.java).apply {
            putExtra(ReaderActivity.EXTRA_PUBLICATION, localPub)
        }
        startActivity(intent)
    }

    private fun updateContinueReadingBanner() {
        val progress = prefsManager.getLastActiveProgress()
        if (progress != null && progress.lastReadPage < progress.totalPages) {
            binding.cardContinueReading.visibility = View.VISIBLE
            binding.tvContinueTitle.text = progress.title
            binding.tvContinueProgress.text = "पृष्ठ ${progress.lastReadPage + 1} / ${progress.totalPages} पर छोड़ा था"
            binding.btnContinueResume.setOnClickListener {
                val pub = CatalogRepository.getPublicationById(progress.publicationId)
                if (pub != null) {
                    val intent = Intent(this, ReaderActivity::class.java).apply {
                        putExtra(ReaderActivity.EXTRA_PUBLICATION, pub)
                        putExtra(ReaderActivity.EXTRA_START_PAGE, progress.lastReadPage)
                    }
                    startActivity(intent)
                }
            }
        } else {
            binding.cardContinueReading.visibility = View.GONE
        }
    }

    private fun applyFilters() {
        var list = CatalogRepository.getAllPublications()

        // 1. Tab filter
        when (currentTab) {
            1 -> { // Favorites
                val favIds = prefsManager.getFavorites()
                list = list.filter { favIds.contains(it.id) }
            }
            2 -> { // Offline
                val offlineIds = prefsManager.getDownloadedIds()
                list = list.filter { offlineIds.contains(it.id) }
            }
        }

        // 2. Category filter
        list = when (currentFilterType) {
            "CHAMPAK" -> list.filter { it.series.contains("Champak", ignoreCase = true) }
            "NANDAN" -> list.filter { it.series.contains("Nandan", ignoreCase = true) }
            "COMICS" -> list.filter { it.category == "COMIC" }
            "CHANDAMAMA" -> list.filter { it.series.contains("Chandamama", ignoreCase = true) }
            "NEWSPAPER" -> list.filter { it.category == "NEWSPAPER" }
            else -> list
        }

        // 3. Search filter
        val search = binding.etSearch.text?.toString().orEmpty().trim()
        if (search.isNotEmpty()) {
            val q = search.lowercase()
            list = list.filter {
                it.title.lowercase().contains(q) ||
                it.series.lowercase().contains(q) ||
                it.description.lowercase().contains(q) ||
                it.year.toString().contains(q)
            }
        }

        adapter.updateData(list)

        if (list.isEmpty()) {
            binding.layoutEmptyState.visibility = View.VISIBLE
            binding.rvCatalog.visibility = View.GONE
        } else {
            binding.layoutEmptyState.visibility = View.GONE
            binding.rvCatalog.visibility = View.VISIBLE
        }
    }
}
