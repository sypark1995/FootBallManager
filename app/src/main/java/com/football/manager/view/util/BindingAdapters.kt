package com.football.manager.view.util

import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("submitList")
    @Suppress("UNCHECKED_CAST")
    fun bindSubmitList(view: RecyclerView, list: List<Any>?) {
        (view.adapter as ListAdapter<Any, *>).submitList(list)
    }

    @JvmStatic
    @BindingAdapter("longToString")
    fun TextView.setLongToString(longValue: Long) {
        text = longValue.toString()
    }

    @JvmStatic
    @BindingAdapter("image")
    fun AppCompatImageView.bindImage(uri: String?) {
        if (uri != null) {
            load(uri)
        }
    }
}

