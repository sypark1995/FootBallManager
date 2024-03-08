package com.football.manager.view.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.football.manager.R
import com.football.manager.view.util.League
import timber.log.Timber

class LeagueAdapter(private val onItemClickListener: (Int) -> Unit) :
    ListAdapter<League, ViewHolder>(LeagueDiffUtil) {

    private var selectedPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_league, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        Timber.e("selectedPosition $selectedPosition")
        holder.bind(item, position == selectedPosition, onItemClickListener)

        holder.itemView.isActivated = item.isSelected
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

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @SuppressLint("ResourceAsColor")
    fun bind(
        item: League,
        isSelected: Boolean,
        onItemClickListener: (Int) -> Unit
    ) {
        itemView.apply {
            val title = findViewById<TextView>(R.id.text_league)
            title.text = resources.getText(item.res)

            setOnClickListener {
                onItemClickListener(item.state)
            }

            if (layoutPosition == 0) {
                this.isSelected = true
            } else {
                this.isSelected = false
            }

            this.isSelected = isSelected

            if (this.isSelected) {
                Timber.e("layoutPosition true")
                title.setBackgroundColor(R.color.black)
            } else {
                Timber.e("layoutPosition true")
                title.setBackgroundColor(R.color.white)
            }
        }
    }
}

