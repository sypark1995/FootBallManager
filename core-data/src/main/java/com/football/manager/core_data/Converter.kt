package com.football.manager.core_data

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken

inline fun <reified T> JsonElement.toList(): List<T> {
    return Gson().fromJson(this, object : TypeToken<List<T>>() {}.type)
}

inline fun <reified T> JsonElement.toData(): T {
    return Gson().fromJson(this, object : TypeToken<T>() {}.type)
}