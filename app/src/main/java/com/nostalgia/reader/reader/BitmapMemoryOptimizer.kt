package com.nostalgia.reader.reader

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream

object BitmapMemoryOptimizer {

    /**
     * Calculates the optimal inSampleSize to downsample high-resolution comic/magazine
     * scans into memory without triggering OutOfMemoryError (OOM).
     */
    fun calculateInSampleSize(
        rawWidth: Int,
        rawHeight: Int,
        reqWidth: Int,
        reqHeight: Int
    ): Int {
        var inSampleSize = 1

        if (rawHeight > reqHeight || rawWidth > reqWidth) {
            val halfHeight: Int = rawHeight / 2
            val halfWidth: Int = rawWidth / 2

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than or equal to the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }

    /**
     * Computes the estimated memory consumption of an uncompressed bitmap.
     * With RGB_565 each pixel is 2 bytes; with ARGB_8888 each pixel is 4 bytes.
     */
    fun estimateBitmapMemoryBytes(width: Int, height: Int, config: Bitmap.Config = Bitmap.Config.RGB_565): Long {
        val bytesPerPixel = when (config) {
            Bitmap.Config.ALPHA_8 -> 1
            Bitmap.Config.RGB_565, Bitmap.Config.ARGB_4444 -> 2
            Bitmap.Config.ARGB_8888 -> 4
            Bitmap.Config.RGBA_F16 -> 8
            else -> 4
        }
        return width.toLong() * height.toLong() * bytesPerPixel
    }

    /**
     * Checks whether an allocation of the given byte size exceeds the safe threshold
     * (e.g. 25% of available heap).
     */
    fun isSafeAllocation(allocationBytes: Long, maxHeapBytes: Long): Boolean {
        if (allocationBytes <= 0 || maxHeapBytes <= 0) return false
        val safeThreshold = (maxHeapBytes * 0.25).toLong()
        return allocationBytes <= safeThreshold
    }

    /**
     * Returns standard recommended comic reader decode options:
     * Prefers RGB_565 to cut memory consumption by 50% compared to ARGB_8888.
     */
    fun getVintageComicDecodeOptions(sampleSize: Int = 1): BitmapFactory.Options {
        return BitmapFactory.Options().apply {
            inSampleSize = sampleSize
            inPreferredConfig = Bitmap.Config.RGB_565
            inDither = true
        }
    }
}
