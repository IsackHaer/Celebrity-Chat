package com.example.celebritychat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.celebritychat.R
import com.example.celebritychat.data.model.Contact
import com.example.celebritychat.ui.HomeFragmentDirections

class ContactListAdapter() : RecyclerView.Adapter<ContactListAdapter.viewHolder>() {

    private var dataset = listOf<Contact>()

    inner class viewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.profileImage_iv)
        val name = view.findViewById<TextView>(R.id.name_tv)
        val lastMessage = view.findViewById<TextView>(R.id.lastMessage_tv)
        val clickableCv = view.findViewById<CardView>(R.id.contact_clickable_cv)
    }

    fun submitList(list: List<Contact>){
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)
        return viewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val contact = dataset[position]
        holder.image.setImageResource(contact.image)
        holder.name.text = contact.name
        holder.clickableCv.setOnClickListener {
            holder.itemView.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToChatFragment(contact.name))
        }
    }
}