package com.example.celebritychat.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.celebritychat.R
import com.example.celebritychat.data.model.Messages
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MessageAdapter() : RecyclerView.Adapter<MessageAdapter.viewHolder>() {

    private var dataset = mutableListOf<Messages>()

    inner class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val messageTv = view.findViewById<TextView>(R.id.message_tv)
        val messageDate = view.findViewById<TextView>(R.id.messageDate_tv)
    }

    // companion objects decides which viewType should be inflated in the onCreateViewHolder
    companion object {
        const val ITEM_MESSAGE = 0
        const val ITEM_ANSWER = 1
    }

    fun submitMessages(messages: MutableList<Messages>) {
        dataset = messages
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        //depending on which viewType is choosen, it'll inflate the correct Layout
        val layoutID = if (viewType == ITEM_MESSAGE) {
            R.layout.message_me_item
        } else {
            R.layout.message_other_item
        }
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(layoutID, parent, false)
        return viewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val message = dataset[position]
        holder.messageTv.text = message.message
        holder.messageDate.text = getCurrentDateAndTime()
    }

    //checks the dataset: Boolean and returns the correct companion object
    override fun getItemViewType(position: Int): Int {
        val message = dataset[position]
        return if (message.answer) {
            ITEM_ANSWER
        } else {
            ITEM_MESSAGE
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentDateAndTime(): String {
        val date = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm")
        val formatted = date.format(formatter)

        return formatted
    }
}