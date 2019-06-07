package com.example.ejemplopaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_item.view.*

class AdapterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {


    fun bind(repo: Test?) {
        if (repo == null) {
            view.name.text = "loading"
        } else {
            showRepoData(repo)
        }
    }

    private fun showRepoData(repo: Test) {
        view.name.text = repo.name
    }

    companion object {
        fun create(parent: ViewGroup): AdapterViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_item, parent, false)
            return AdapterViewHolder(view)
        }
    }
}