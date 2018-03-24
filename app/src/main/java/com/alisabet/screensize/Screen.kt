package com.alisabet.screensize

import android.content.Context
import android.content.res.Configuration
import android.util.DisplayMetrics
import android.view.WindowManager

class Screen {
    companion object {
        //result : 1440 * 2560 for note 4
        fun getScreenResolution(context: Context): String {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val metrics = DisplayMetrics()
            display.getMetrics(metrics)
            val width = metrics.widthPixels
            val height = metrics.heightPixels
            return "{$width,$height}"
        }
        //normal screen for note 4
        fun getScreenSize(context: Context) : String{
            val screenSize = context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK
            val toastMsg: String
            when (screenSize) {
                Configuration.SCREENLAYOUT_SIZE_LARGE -> toastMsg = "Large screen"
                Configuration.SCREENLAYOUT_SIZE_NORMAL -> toastMsg = "Normal screen"
                Configuration.SCREENLAYOUT_SIZE_SMALL -> toastMsg = "Small screen"
                else -> toastMsg = "Screen size is neither large, normal or small"
            }
            return toastMsg
        }
        //xxxhigh dpi for note 4
        fun getScreenDP(context: Context) : String{
            val density = context.resources.displayMetrics.densityDpi
            val toastMsg: String
            when (density) {
                DisplayMetrics.DENSITY_LOW -> toastMsg = "low dpi"
                DisplayMetrics.DENSITY_MEDIUM -> toastMsg = "medium dpi"
                DisplayMetrics.DENSITY_HIGH -> toastMsg = "high dpi"
                DisplayMetrics.DENSITY_XHIGH -> toastMsg = "xhigh dpi"
                DisplayMetrics.DENSITY_XXHIGH -> toastMsg = "xxhigh dpi"
                DisplayMetrics.DENSITY_XXXHIGH -> toastMsg = "xxxhigh dpi"
                DisplayMetrics.DENSITY_TV -> toastMsg = "tv dpi"
                else -> toastMsg = "Screen size is neither low, medium, high, xhigh, xxhigh, xxxhigh ot tv"
            }
            return toastMsg
        }
    }
}