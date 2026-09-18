package com.nostalgia.reader

import android.graphics.Bitmap
import com.nostalgia.reader.reader.BitmapMemoryOptimizer
import org.junit.Assert.*
import org.junit.Test

/**
 * Senior QA Test Suite: Memory Optimization & OOM Prevention
 */
class BitmapMemoryOptimizerTest {

    @Test
    fun `test inSampleSize calculation for large scanned magazine pages`() {
        // High-res scan: 4000x3000, target screen: 1080x1920
        val sampleSize = BitmapMemoryOptimizer.calculateInSampleSize(3000, 4000, 1080, 1920)
        assertEquals("Sample size should scale by power of 2", 2, sampleSize)

        // Extreme scan: 8000x6000
        val largeSample = BitmapMemoryOptimizer.calculateInSampleSize(6000, 8000, 1080, 1920)
        assertTrue("Sample size must be at least 4 to prevent OOM", largeSample >= 4)

        // Small image within bounds
        val noDownsample = BitmapMemoryOptimizer.calculateInSampleSize(800, 600, 1080, 1920)
        assertEquals("Small image must not be downsampled", 1, noDownsample)
    }

    @Test
    fun `test bitmap memory estimation formulas`() {
        val width = 1000
        val height = 2000

        val rgb565Bytes = BitmapMemoryOptimizer.estimateBitmapMemoryBytes(width, height, Bitmap.Config.RGB_565)
        val argb8888Bytes = BitmapMemoryOptimizer.estimateBitmapMemoryBytes(width, height, Bitmap.Config.ARGB_8888)

        // RGB_565 uses 2 bytes per pixel, ARGB_8888 uses 4 bytes per pixel
        assertEquals(4_000_000L, rgb565Bytes)
        assertEquals(8_000_000L, argb8888Bytes)
        assertEquals("RGB_565 must consume exactly half the RAM of ARGB_8888", rgb565Bytes * 2, argb8888Bytes)
    }

    @Test
    fun `test safe allocation threshold calculation`() {
        val maxHeap = 256 * 1024 * 1024L // 256 MB max heap
        val safe20Mb = 20 * 1024 * 1024L
        val dangerous100Mb = 100 * 1024 * 1024L

        assertTrue("20 MB allocation should be deemed safe", BitmapMemoryOptimizer.isSafeAllocation(safe20Mb, maxHeap))
        assertFalse("100 MB allocation on 256MB heap should be rejected", BitmapMemoryOptimizer.isSafeAllocation(dangerous100Mb, maxHeap))
    }
}
