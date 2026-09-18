package com.nostalgia.reader.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nostalgia.reader.model.ReadingProgress

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveReadingProgress(progress: ReadingProgress) {
        val json = gson.toJson(progress)
        prefs.edit()
            .putString(KEY_PROGRESS_PREFIX + progress.publicationId, json)
            .putString(KEY_LAST_ACTIVE_ID, progress.publicationId)
            .apply()
    }

    fun getReadingProgress(publicationId: String): ReadingProgress? {
        val json = prefs.getString(KEY_PROGRESS_PREFIX + publicationId, null) ?: return null
        return try {
            gson.fromJson(json, ReadingProgress::class.java)
        } catch (e: Exception) {
            null
        }
    }

    fun getLastActiveProgress(): ReadingProgress? {
        val lastId = prefs.getString(KEY_LAST_ACTIVE_ID, null) ?: return null
        return getReadingProgress(lastId)
    }

    fun toggleFavorite(publicationId: String): Boolean {
        val favorites = getFavorites().toMutableSet()
        val newState = if (favorites.contains(publicationId)) {
            favorites.remove(publicationId)
            false
        } else {
            favorites.add(publicationId)
            true
        }
        prefs.edit().putStringSet(KEY_FAVORITES, favorites).apply()
        return newState
    }

    fun isFavorite(publicationId: String): Boolean {
        val favorites = prefs.getStringSet(KEY_FAVORITES, emptySet()) ?: emptySet()
        return favorites.contains(publicationId)
    }

    fun getFavorites(): Set<String> {
        return prefs.getStringSet(KEY_FAVORITES, emptySet()) ?: emptySet()
    }

    fun markDownloaded(publicationId: String, downloaded: Boolean) {
        val downloadedSet = getDownloadedIds().toMutableSet()
        if (downloaded) {
            downloadedSet.add(publicationId)
        } else {
            downloadedSet.remove(publicationId)
        }
        prefs.edit().putStringSet(KEY_DOWNLOADED, downloadedSet).apply()
    }

    fun isDownloaded(publicationId: String): Boolean {
        val downloaded = prefs.getStringSet(KEY_DOWNLOADED, emptySet()) ?: emptySet()
        return downloaded.contains(publicationId)
    }

    fun getDownloadedIds(): Set<String> {
        return prefs.getStringSet(KEY_DOWNLOADED, emptySet()) ?: emptySet()
    }

    fun setReadingTheme(theme: String) {
        prefs.edit().putString(KEY_THEME, theme).apply()
    }

    fun getReadingTheme(): String {
        return prefs.getString(KEY_THEME, "PARCHMENT") ?: "PARCHMENT"
    }

    companion object {
        private const val PREFS_NAME = "nostalgia_reader_prefs"
        private const val KEY_PROGRESS_PREFIX = "progress_"
        private const val KEY_LAST_ACTIVE_ID = "last_active_publication"
        private const val KEY_FAVORITES = "user_favorites"
        private const val KEY_DOWNLOADED = "offline_downloaded"
        private const val KEY_THEME = "reading_theme"
    }
}
