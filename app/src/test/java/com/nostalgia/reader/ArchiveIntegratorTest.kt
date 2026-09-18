package com.nostalgia.reader

import com.nostalgia.reader.reader.ArchiveIntegrator
import org.junit.Assert.*
import org.junit.Test

/**
 * Senior QA Test Suite: Archive Format & Importer Verification
 */
class ArchiveIntegratorTest {

    @Test
    fun `test supported archive extension detection`() {
        assertTrue("PDF should be supported", ArchiveIntegrator.isSupportedArchive("champak_june_1994.pdf"))
        assertTrue("CBZ should be supported", ArchiveIntegrator.isSupportedArchive("chacha_chaudhary_01.cbz"))
        assertTrue("CBR should be supported", ArchiveIntegrator.isSupportedArchive("tinkle_issue_102.cbr"))
        assertTrue("ZIP should be supported", ArchiveIntegrator.isSupportedArchive("nandan_archive.zip"))

        // Case insensitivity
        assertTrue("Uppercase PDF should be supported", ArchiveIntegrator.isSupportedArchive("CHAMPAK.PDF"))
        assertTrue("Mixed case CBZ should be supported", ArchiveIntegrator.isSupportedArchive("Comic.Cbz"))

        // Unsupported formats
        assertFalse("EXE should be rejected", ArchiveIntegrator.isSupportedArchive("malware.exe"))
        assertFalse("MP4 should be rejected", ArchiveIntegrator.isSupportedArchive("video.mp4"))
        assertFalse("Empty string should be rejected", ArchiveIntegrator.isSupportedArchive(""))
        assertFalse("Null string should be rejected", ArchiveIntegrator.isSupportedArchive(null))
    }

    @Test
    fun `test format enum detection`() {
        assertEquals(ArchiveIntegrator.ArchiveFormat.PDF, ArchiveIntegrator.detectFormat("doc.pdf"))
        assertEquals(ArchiveIntegrator.ArchiveFormat.CBZ, ArchiveIntegrator.detectFormat("comic.cbz"))
        assertEquals(ArchiveIntegrator.ArchiveFormat.CBZ, ArchiveIntegrator.detectFormat("archive.zip"))
        assertEquals(ArchiveIntegrator.ArchiveFormat.CBR, ArchiveIntegrator.detectFormat("comic.cbr"))
        assertEquals(ArchiveIntegrator.ArchiveFormat.UNKNOWN, ArchiveIntegrator.detectFormat("song.mp3"))
    }
}
