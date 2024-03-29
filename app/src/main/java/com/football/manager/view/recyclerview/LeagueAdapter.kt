package com.football.manager.view.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.football.manager.databinding.ItemLeagueBinding
import com.football.manager.view.util.League
import timber.log.Timber

class LeagueAdapter(private val onItemClickListener: (Int) -> Unit) :
    ListAdapter<League, ViewHolder>(LeagueDiffUtil) {

    private var selectedPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLeagueBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.e("selectedPosition $selectedPosition")
        holder.bind(currentList[position], onItemClickListener)
    }
}

object LeagueDiffUtil : DiffUtil.ItemCallback<League>() {
    override fun areItemsTheSame(
        oldItem: League,
        newItem: League
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: League,
        newItem: League
    ): Boolean {
        return oldItem.state == newItem.state
    }
}

class ViewHolder(val binding: ItemLeagueBinding) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("ResourceAsColor")
    fun bind(
        item: League,
        onItemClickListener: (Int) -> Unit
    ) {
        binding.apply {
            textLeague.text = root.resources.getText(item.res)

            root.setOnClickListener {
                !item.isSelected
                Timber.e("layoutPosition $layoutPosition")

                onItemClickListener(item.state)
            }
        }
    }
}

