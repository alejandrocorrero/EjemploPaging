package com.example.ejemplopaging

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Adapter: ListAdapter<Test, androidx.recyclerview.widget.RecyclerView.ViewHolder>(COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
      return AdapterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            (holder as AdapterViewHolder).bind(item)
        }
    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Test>() {
            override fun areItemsTheSame(oldItem: Test, newItem: Test): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Test, newItem: Test): Boolean =
                oldItem == newItem
        }
    }
}