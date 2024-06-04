package com.football.manager.view.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.football.manager.core_network.model.detail.Standing
import com.football.manager.databinding.ItemRecentlyBinding
import timber.log.Timber

class RecentlyAdapter(
//    private val whenItemClicked: (Standing) -> Unit
) : ListAdapter<Standing, RecentlyAdapter.ViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecentlyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).apply {
            binding.root.setOnClickListener {
//                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
//                whenItemClicked(
//                    getItem(position!!)
//                )
                Timber.e("getItem / %s", getItem(position))

            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemRecentlyBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun binding(item: Standing) {
            binding.apply {
                standing = item
            }
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Standing>() {
            override fun areItemsTheSame(oldItem: Standing, newItem: Standing): Boolean =
                oldItem.team.id == newItem.team.id

            override fun areContentsTheSame(oldItem: Standing, newItem: Standing): Boolean =
                oldItem == newItem
        }
    }
}