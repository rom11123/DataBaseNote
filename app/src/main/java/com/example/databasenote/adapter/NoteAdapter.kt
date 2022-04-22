package com.example.databasenote.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.databasenote.R
import com.example.databasenote.model.NoteModel
import com.example.databasenote.ui.start.StartFragment

class NoteAdapter() :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private val listNotes: MutableList<NoteModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNotes[position])
    }

    override fun getItemCount(): Int = listNotes.size


    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<NoteModel>) {
        this.listNotes.clear()
        this.listNotes.addAll(newList)
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: NoteModel) {
            itemView.findViewById<TextView>(R.id.item_title).text = item.title


        }

    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(listNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}