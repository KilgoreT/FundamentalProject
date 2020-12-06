package me.apomazkin.fundamentalproject

import android.content.res.Resources

fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
fun Int.toDP(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()