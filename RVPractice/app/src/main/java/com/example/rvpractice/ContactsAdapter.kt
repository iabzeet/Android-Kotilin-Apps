package com.example.rvpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(val context: Context, val contacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    // Create a view -- expensive operation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)  // Calling the ViewHolder constructor with the view
    }

    // Return how many items are in the data set
    override fun getItemCount() = contacts.size

    // Bind the data at position into the ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    // ViewHolder is the wrapper around the view that we defined
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvAge: TextView = itemView.findViewById(R.id.tvAge)

        fun bind(contact: Person) {
            // Bind the data in the contact into the views (tvName and tvAge)
            tvName.text = contact.name
            tvAge.text = "Age: ${contact.age}"
        }
    }
}
