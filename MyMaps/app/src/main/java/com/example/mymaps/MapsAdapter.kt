package com.example.mymaps

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymaps.models.UserMap

private const val TAG = "MapsAdapter"
class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    //inflate the view and wrap that inside of a VH
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_map, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userMaps.size

    //grab the data at the position and bind it into a view located inside of a VH
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMap = userMaps[position]
        //setting a clicklistener on itemview
        //what we'd like is mainactivity to be notified of the taps
        holder.itemView.setOnClickListener {
            Log.i(TAG, "Tapped on position $position")
            onClickListener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(R.id.tvMapTitle)
        textViewTitle.text = userMap.title
    }

    //VH takes the constructor of the parent class which is itemview
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}
