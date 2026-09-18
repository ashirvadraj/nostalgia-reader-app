package com.nostalgia.reader.reader

import java.io.File
import java.util.Locale

object ArchiveIntegrator {

    val SUPPORTED_EXTENSIONS = listOf("pdf", "cbz", "cbr", "zip")

    /**
     * Validates if a file name or path is a supported comic/magazine archive.
     */
    fun isSupportedArchive(fileName: String?): Boolean {
        if (fileName.isNullOrBlank()) return false
        val extension = fileName.substringAfterLast('.', "").lowercase(Locale.ROOT)
        return SUPPORTED_EXTENSIONS.contains(extension)
    }

    /**
     * Determines comic format type for appropriate reader rendering.
     */
    fun detectFormat(fileName: String): ArchiveFormat {
        val ext = fileName.substringAfterLast('.', "").lowercase(Locale.ROOT)
        return when (ext) {
            "pdf" -> ArchiveFormat.PDF
            "cbz", "zip" -> ArchiveFormat.CBZ
            "cbr" -> ArchiveFormat.CBR
            else -> ArchiveFormat.UNKNOWN
        }
    }

    enum class ArchiveFormat {
        PDF, CBZ, CBR, UNKNOWN
    }
}
