package com.example.newnoteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CardAdapter internal constructor(context: Context, dataSet: Array<String>) : RecyclerView.Adapter<CardAdapter.MyViewHolder>(){

    private val context: Context
    private val data: Array<String>

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView : TextView

        init{
            textView = itemView.findViewById(R.id.noteText) as TextView
        }
    }

    init{
        data = dataSet
        this.context = context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.MyViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardAdapter.MyViewHolder, position: Int) {
        val title = holder.textView
        title.setText(data[position])
    }

    override fun getItemCount(): Int {
       return data.size
    }

}