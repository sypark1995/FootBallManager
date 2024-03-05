package com.football.manager.view.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.football.manager.R
import com.football.manager.view.util.League

class LeagueAdapter(val onItemClickListener: (Int) -> Unit) :
    ListAdapter<League, ViewHolder>(MyItemCallback()) {

    private var selectedPosition: Int = RecyclerView.NO_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_league, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position == selectedPosition, onItemClickListener)
    }


    class MyItemCallback : DiffUtil.ItemCallback<League>() {
        override fun areItemsTheSame(
            oldItem: League,
            newItem: League
        ): Boolean {
            return oldItem.state == newItem.state
        }

        override fun areContentsTheSame(
            oldItem: League,
            newItem: League
        ): Boolean {
            return oldItem == newItem
        }
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(
        item: League,
        isSelected: Boolean,
        onItemClickListener: (Int) -> Unit
    ) {
        itemView.apply {
            setOnClickListener {
                onItemClickListener(layoutPosition)
            }

            findViewById<TextView>(R.id.text_league).text = resources.getText(item.res)

            this.isSelected = isSelected

            if (this.isSelected) {

            } else {

            }
        }
    }
}

