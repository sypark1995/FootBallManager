package com.football.manager.core_data.extension

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun Date.dateToString(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+HH:mm")
    return dateFormat.format(this)
}

@SuppressLint("SimpleDateFormat")
fun String.stringToDate(): Date? {
    return try {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+HH:mm")
        dateFormat.parse(this)
    } catch (e: Exception) {
        null
    }
}

@SuppressLint("SimpleDateFormat")
fun getTimeNow(): String {
    val date = Date(System.currentTimeMillis())
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+HH:mm")
    return dateFormat.format(date)
}

@SuppressLint("SimpleDateFormat")
fun getYearsNow(): String {
    val nowTime = System.currentTimeMillis()
    val dateFormat = SimpleDateFormat("yyyy")

    return dateFormat.format(nowTime)
}

fun currentDate(): Date {
    return Calendar.getInstance().time
}

fun LocalDate.test() {

}