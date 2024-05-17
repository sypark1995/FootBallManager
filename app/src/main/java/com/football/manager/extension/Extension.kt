package com.football.manager.extension

import android.view.View

object StringUtil {
    fun longToString(value: Long):String {
        return value.toString()
    }
}


fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}