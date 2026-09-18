package com.nostalgia.reader.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.nostalgia.reader.R
import com.nostalgia.reader.data.CatalogRepository
import com.nostalgia.reader.data.PreferencesManager
import com.nostalgia.reader.databinding.ActivityIssueDetailBinding
import com.nostalgia.reader.model.Publication

class IssueDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIssueDetailBinding
    private lateinit var prefsManager: PreferencesManager
    private var publication: Publication? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIssueDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefsManager = PreferencesManager(this)

        val pubId = intent.getStringExtra(EXTRA_PUBLICATION_ID)
        publication = if (pubId != null) {
            CatalogRepository.getPublicationById(pubId)
        } else {
            intent.getSerializableExtra(EXTRA_PUBLICATION) as? Publication
        }

        if (publication == null) {
            Toast.makeText(this, "अंक विवरण नहीं मिला", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        setupViews(publication!!)
    }

    private fun setupViews(pub: Publication) {
        binding.tvDetailHeaderTitle.text = pub.series
        binding.tvDetailTitle.text = pub.title
        binding.badgeSeries.text = pub.series
        binding.badgeYear.text = "वर्ष: ${pub.year}"
        binding.badgePages.text = "${pub.pageCount} पृष्ठ"
        binding.tvDetailDescription.text = pub.description

        // Cover image
        Glide.with(this)
            .load(pub.coverUrl)
            .placeholder(R.drawable.ic_book)
            .error(R.drawable.ic_book)
            .centerCrop()
            .into(binding.imgDetailCover)

        // Back button
        binding.btnDetailBack.setOnClickListener {
            finish()
        }

        // Favorite Toggle
        updateFavoriteIcon(pub.id)
        binding.btnDetailFav.setOnClickListener {
            val isNowFav = prefsManager.toggleFavorite(pub.id)
            updateFavoriteIcon(pub.id)
            val msg = if (isNowFav) "पसंदीदा में जोड़ा गया" else "पसंदीदा से हटाया गया"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        // Offline Download Button
        updateDownloadButton(pub.id)
        binding.btnDownloadOffline.setOnClickListener {
            val isCurrentlyDownloaded = prefsManager.isDownloaded(pub.id)
            if (isCurrentlyDownloaded) {
                prefsManager.markDownloaded(pub.id, false)
                Toast.makeText(this, "ऑफ़लाइन संग्रह से हटाया गया", Toast.LENGTH_SHORT).show()
            } else {
                prefsManager.markDownloaded(pub.id, true)
                Toast.makeText(this, "ऑफ़लाइन पढ़ने के लिए सुरक्षित कर लिया गया!", Toast.LENGTH_SHORT).show()
            }
            updateDownloadButton(pub.id)
        }

        // Read Now Button
        binding.btnReadNow.setOnClickListener {
            val intent = Intent(this, ReaderActivity::class.java).apply {
                putExtra(ReaderActivity.EXTRA_PUBLICATION, pub)
            }
            startActivity(intent)
        }
    }

    private fun updateFavoriteIcon(pubId: String) {
        val isFav = prefsManager.isFavorite(pubId)
        if (isFav) {
            binding.btnDetailFav.setImageResource(R.drawable.ic_heart_filled)
            binding.btnDetailFav.setColorFilter(ContextCompat.getColor(this, R.color.primary))
        } else {
            binding.btnDetailFav.setImageResource(R.drawable.ic_heart)
            binding.btnDetailFav.setColorFilter(ContextCompat.getColor(this, R.color.text_primary))
        }
    }

    private fun updateDownloadButton(pubId: String) {
        val isDownloaded = prefsManager.isDownloaded(pubId)
        if (isDownloaded) {
            binding.btnDownloadOffline.text = getString(R.string.btn_downloaded)
            binding.btnDownloadOffline.setBackgroundResource(R.drawable.bg_chip_selected)
        } else {
            binding.btnDownloadOffline.text = getString(R.string.btn_download_offline)
            binding.btnDownloadOffline.setBackgroundResource(R.drawable.bg_chip)
        }
    }

    companion object {
        const val EXTRA_PUBLICATION_ID = "extra_publication_id"
        const val EXTRA_PUBLICATION = "extra_publication"
    }
}
