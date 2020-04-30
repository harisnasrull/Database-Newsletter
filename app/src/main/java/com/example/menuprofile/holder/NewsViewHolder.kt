package com.example.menuprofile.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.title_view
    val body = itemView.body_view
    val date = itemView.date_view
    val btnUpdate = itemView.btn_update
    val btnDelete = itemView.btn_delete
}