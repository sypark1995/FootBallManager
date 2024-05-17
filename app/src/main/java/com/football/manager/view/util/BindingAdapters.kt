package com.football.manager.view.util

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.football.manager.R
import com.football.manager.core_data.ApiResult
import com.football.manager.extension.hide
import com.football.manager.extension.invisible
import com.football.manager.extension.show
import timber.log.Timber

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("submitList")
    @Suppress("UNCHECKED_CAST")
    fun bindSubmitList(view: RecyclerView, list: List<Any>) {
        (view.adapter as ListAdapter<Any, *>).submitList(list)
    }

    @JvmStatic
    @BindingAdapter("longToString")
    fun TextView.setLongToString(longValue: Long) {
        text = longValue.toString()
    }

    @JvmStatic
    @BindingAdapter("bindingImage")
    fun bindImage(imageView: ImageView, uri: String) {
        imageView.load(uri) {

        }
    }

    @JvmStatic
    @BindingAdapter("show")
    fun bindIsVisibility(view: View, apiResult: ApiResult<*>) {
        if (apiResult is ApiResult.Loading) view.show() else view.hide()
        Timber.e("!!!!! $apiResult")
    }

    @JvmStatic
    @BindingAdapter("setIncludeTextView")
    fun bindingIncludeView(includeView: View, text: String) {
        includeView.findViewById<TextView>(R.id.text_state).text = text
    }

    @JvmStatic
    @BindingAdapter("setIncludeImageView")
    fun bindingIncludeView(includeView: View, drawable: Drawable) {
        includeView.findViewById<ImageView>(R.id.image_state).background = drawable
    }

    @JvmStatic
    @BindingAdapter("showRanking")
    fun bindingRanking(view: View, rank: Long) {
        if (rank <= 6 || rank >= 18) {
            view.show()

            if (rank.toInt() >= 18) {
                view.setBackgroundResource(R.drawable.round_8_red)
            } else if (rank.toInt() == 6) {
                view.setBackgroundResource(R.drawable.round_8_blue)
            } else if (rank.toInt() == 5) {
                view.setBackgroundResource(R.drawable.round_8_drak_blue)
            }
        } else {
            view.invisible()
        }
    }
}

