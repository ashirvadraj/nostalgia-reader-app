package com.nostalgia.reader

import com.nostalgia.reader.data.CatalogRepository
import org.junit.Assert.*
import org.junit.Test

/**
 * Senior QA Test Suite: Catalog Integrity, Daily Newspapers & Monthly Issue Verification
 */
class CatalogRepositoryTest {

    @Test
    fun `test all childhood publications are present and non-empty`() {
        val all = CatalogRepository.getAllPublications()
        assertTrue("Catalog must not be empty", all.isNotEmpty())
        assertTrue("Catalog should have at least 15 items including newspapers", all.size >= 15)

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
    fun `test all india daily newspapers hindi and english are present with complete pages`() {
        val dailies = CatalogRepository.getDailyNewspapers("19 September 2026")
        assertTrue("Daily newspapers must not be empty", dailies.isNotEmpty())
        assertTrue("Should include at least 10 major daily newspapers", dailies.size >= 10)

        // Check key Hindi newspapers
        val hindiDailies = dailies.filter { it.language == "hi" }
        assertTrue("Must have Hindi dailies", hindiDailies.isNotEmpty())
        val hindiNames = hindiDailies.map { it.series }.joinToString(" ")
        assertTrue("Must include Dainik Jagran", hindiNames.contains("Dainik Jagran"))
        assertTrue("Must include Dainik Bhaskar", hindiNames.contains("Dainik Bhaskar"))
        assertTrue("Must include Amar Ujala", hindiNames.contains("Amar Ujala"))
        assertTrue("Must include Navbharat Times", hindiNames.contains("Navbharat Times"))
        assertTrue("Must include Hindustan", hindiNames.contains("Hindustan"))
        assertTrue("Must include Rajasthan Patrika", hindiNames.contains("Rajasthan Patrika"))

        // Check key English newspapers
        val englishDailies = dailies.filter { it.language == "en" }
        assertTrue("Must have English dailies", englishDailies.isNotEmpty())
        val englishNames = englishDailies.map { it.series }.joinToString(" ")
        assertTrue("Must include The Hindu", englishNames.contains("The Hindu"))
        assertTrue("Must include The Indian Express", englishNames.contains("The Indian Express"))
        assertTrue("Must include Times of India", englishNames.contains("Times of India"))
        assertTrue("Must include Economic Times", englishNames.contains("Economic Times"))
        assertTrue("Must include Mint", englishNames.contains("Mint"))

        // Verify Complete Newspaper structure (8 broadsheet sections)
        for (daily in dailies) {
            assertTrue("Each newspaper must be marked isDailyNewspaper", daily.isDailyNewspaper)
            assertEquals("Daily newspaper must have 8 complete broadsheet pages", 8, daily.pageCount)
            assertEquals("Pages list size must match pageCount", 8, daily.pages.size)
            assertNotNull("Daily newspaper must have an official epaperUrl", daily.epaperUrl)
            assertTrue("epaperUrl must start with http", daily.epaperUrl!!.startsWith("http"))

            // Verify sections include Front Page, Editorial, Business, Sports
            val sections = daily.pages.mapNotNull { it.sectionName }.joinToString(" ")
            assertTrue("Sections must contain Front page or मुखपृष्ठ", sections.contains("Front") || sections.contains("मुखपृष्ठ"))
            assertTrue("Sections must contain Editorial or संपादकीय", sections.contains("Editorial") || sections.contains("संपादकीय"))
        }
    }

    @Test
    fun `test dynamic monthly issue generator for champak august 2026`() {
        val aug2026Champak = CatalogRepository.getOrFetchMonthlyIssue("Champak", 8, 2026)
        assertNotNull("August 2026 Champak must not be null", aug2026Champak)
        assertEquals("Series must be Champak", "Champak", aug2026Champak.series)
        assertEquals("Year must be 2026", 2026, aug2026Champak.year)
        assertEquals("Month must be 8", 8, aug2026Champak.month)
        assertTrue("Title must mention अगस्त or August", aug2026Champak.title.contains("अगस्त") || aug2026Champak.title.contains("August"))
        assertTrue("Page count must be >= 6", aug2026Champak.pageCount >= 6)

        // Verify complete magazine stories
        val allStories = aug2026Champak.pages.mapNotNull { "${it.storyTitle.orEmpty()} ${it.storyText.orEmpty()}" }.joinToString(" ")
        assertTrue("Must contain Cheeku stories", allStories.contains("चीकू") || allStories.contains("Cheeku"))
    }

    @Test
    fun `test dynamic monthly issue generator for any custom month and year`() {
        val jul2025Nandan = CatalogRepository.getOrFetchMonthlyIssue("Nandan", 7, 2025)
        assertEquals(2025, jul2025Nandan.year)
        assertEquals(7, jul2025Nandan.month)
        assertTrue(jul2025Nandan.title.contains("2025"))
        assertEquals(6, jul2025Nandan.pages.size)

        val jan1980Chandamama = CatalogRepository.getOrFetchMonthlyIssue("Chandamama", 1, 1980)
        assertEquals(1980, jan1980Chandamama.year)
        assertEquals(1, jan1980Chandamama.month)
        assertTrue(jan1980Chandamama.title.contains("1980"))
    }

    @Test
    fun `test month and year filtering accuracy`() {
        // Ensure August 2026 issue is present
        CatalogRepository.getOrFetchMonthlyIssue("Champak", 8, 2026)
        val aug2026List = CatalogRepository.filterByMonthAndYear(8, 2026)
        assertTrue("Must find issues for August 2026", aug2026List.isNotEmpty())
        assertTrue("All returned issues must have year 2026 and month 8", aug2026List.all { it.year == 2026 && it.month == 8 })
    }

    @Test
    fun `test search functionality across newspapers and monthly magazines`() {
        val jagran = CatalogRepository.searchPublications("जागरण")
        assertTrue("Search for जागरण should return Dainik Jagran", jagran.isNotEmpty())

        val hindu = CatalogRepository.searchPublications("Hindu")
        assertTrue("Search for Hindu should return The Hindu", hindu.isNotEmpty())

        val aug = CatalogRepository.searchPublications("अगस्त 2026")
        assertTrue("Search for अगस्त 2026 should return August 2026 editions", aug.isNotEmpty())
    }
}
