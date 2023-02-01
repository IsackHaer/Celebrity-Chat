package com.example.celebritychat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.celebritychat.R

class MessageAdapter() : RecyclerView.Adapter<MessageAdapter.viewHolder>() {

    private var dataset = mutableListOf<String>()

    inner class viewHolder(view: View): RecyclerView.ViewHolder(view){
        val messageTv = view.findViewById<TextView>(R.id.message_tv)
        val sendBtn = view.findViewById<ImageButton>(R.id.chat_send_btn)
    }

    fun submitMessages(messages: MutableList<String>){
        dataset = messages
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_me_item, parent, false)
        return viewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val message = dataset[position]

        holder.messageTv.text = message

    }


}