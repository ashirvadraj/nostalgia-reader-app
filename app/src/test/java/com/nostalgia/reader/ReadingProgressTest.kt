package com.nostalgia.reader

import com.google.gson.Gson
import com.nostalgia.reader.model.ReadingProgress
import org.junit.Assert.*
import org.junit.Test

/**
 * Senior QA Test Suite: Reading Progress Serialization
 */
class ReadingProgressTest {

    private val gson = Gson()

    @Test
    fun `test reading progress json serialization and deserialization`() {
        val progress = ReadingProgress(
            publicationId = "champak-1994-jun",
            title = "चंपक - जून 1994",
            lastReadPage = 3,
            totalPages = 6,
            lastReadTimestamp = 1716000000000L,
            readingTheme = "SEPIA"
        )

        val json = gson.toJson(progress)
        assertNotNull("Serialized JSON should not be null", json)
        assertTrue("JSON should contain publicationId", json.contains("champak-1994-jun"))
        assertTrue("JSON should contain readingTheme", json.contains("SEPIA"))

        val deserialized = gson.fromJson(json, ReadingProgress::class.java)
        assertEquals(progress.publicationId, deserialized.publicationId)
        assertEquals(progress.title, deserialized.title)
        assertEquals(progress.lastReadPage, deserialized.lastReadPage)
        assertEquals(progress.totalPages, deserialized.totalPages)
        assertEquals(progress.readingTheme, deserialized.readingTheme)
    }
}
