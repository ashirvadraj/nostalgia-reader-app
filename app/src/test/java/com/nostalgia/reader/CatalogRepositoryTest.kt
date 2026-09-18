package com.nostalgia.reader

import com.nostalgia.reader.data.CatalogRepository
import org.junit.Assert.*
import org.junit.Test

/**
 * Senior QA Test Suite: Catalog Integrity & Search Verification
 */
class CatalogRepositoryTest {

    @Test
    fun `test all childhood publications are present and non-empty`() {
        val all = CatalogRepository.getAllPublications()
        assertTrue("Catalog must not be empty", all.isNotEmpty())
        assertTrue("Catalog should have at least 8 vintage issues", all.size >= 8)

        // Verify key childhood franchises exist
        val titles = all.map { it.title }.joinToString(" ")
        assertTrue("Must include Champak", titles.contains("चंपक") || titles.contains("Champak"))
        assertTrue("Must include Nandan", titles.contains("नंदन"))
        assertTrue("Must include Chandamama", titles.contains("चंदामामा"))
        assertTrue("Must include Chacha Chaudhary", titles.contains("चाचा चौधरी"))
        assertTrue("Must include Billoo", titles.contains("बिल्लू"))
        assertTrue("Must include Panchatantra", titles.contains("पंचतंत्र"))
        assertTrue("Must include Tinkle", titles.contains("Tinkle"))
        assertTrue("Must include Sunday Strips", titles.contains("रविवार") || titles.contains("Phantom"))
    }

    @Test
    fun `test category filtering accuracy`() {
        val magazines = CatalogRepository.filterByCategory("MAGAZINE")
        assertTrue("Must have magazines", magazines.isNotEmpty())
        assertTrue("All filtered magazines must have category MAGAZINE", magazines.all { it.category == "MAGAZINE" })

        val comics = CatalogRepository.filterByCategory("COMIC")
        assertTrue("Must have comics", comics.isNotEmpty())
        assertTrue("All filtered comics must have category COMIC", comics.all { it.category == "COMIC" })

        val newspapers = CatalogRepository.filterByCategory("NEWSPAPER")
        assertTrue("Must have newspaper strips", newspapers.isNotEmpty())
        assertTrue("All filtered newspapers must have category NEWSPAPER", newspapers.all { it.category == "NEWSPAPER" })
    }

    @Test
    fun `test decade filtering accuracy`() {
        val nineties = CatalogRepository.filterByDecade("1990s")
        assertTrue("1990s decade should have issues", nineties.isNotEmpty())
        assertTrue("Every issue in 1990s filter must be between 1990 and 1999", nineties.all { it.year in 1990..1999 })

        val eighties = CatalogRepository.filterByDecade("1980s")
        assertTrue("1980s decade should have issues", eighties.isNotEmpty())
        assertTrue("Every issue in 1980s filter must be between 1980 and 1989", eighties.all { it.year in 1980..1989 })
    }

    @Test
    fun `test search functionality across titles characters and years`() {
        // Search by iconic character
        val cheekuResults = CatalogRepository.searchPublications("चीकू")
        assertTrue("Search for चीकू should find Champak issues", cheekuResults.isNotEmpty())

        val sabuResults = CatalogRepository.searchPublications("साबू")
        assertTrue("Search for साबू should find Chacha Chaudhary", sabuResults.isNotEmpty())

        val yearResults = CatalogRepository.searchPublications("1994")
        assertTrue("Search by year 1994 should return matching issues", yearResults.isNotEmpty())

        // Non-existent search
        val emptyResults = CatalogRepository.searchPublications("NonExistentBookXYZ123")
        assertTrue("Irrelevant search must return empty list", emptyResults.isEmpty())
    }

    @Test
    fun `test publication page structure and sequential integrity`() {
        val all = CatalogRepository.getAllPublications()
        for (pub in all) {
            assertTrue("Publication ${pub.id} must have pageCount > 0", pub.pageCount > 0)
            assertEquals("Publication ${pub.id} pageCount must match pages size", pub.pageCount, pub.pages.size)

            // Verify sequential 1-based page numbering
            for (i in pub.pages.indices) {
                assertEquals("Page number must be 1-indexed and sequential", i + 1, pub.pages[i].pageNumber)
                assertNotNull("Story title or text must be present", pub.pages[i].storyTitle ?: pub.pages[i].storyText)
            }
        }
    }
}
