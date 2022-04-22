package com.gamecodeschool.githubuserapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListUserAdapter(private val listUserAdapter: ArrayList<DetailUserParcel>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.data_tabel,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, avatar) = listUserAdapter[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvUsername.text = username
        holder.itemView.setOnClickListener{
           onItemClickCallback.onItemClicked(listUserAdapter[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listUserAdapter.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_photo)
        var tvName: TextView = itemView.findViewById(R.id.name)
        val tvUsername: TextView = itemView.findViewById(R.id.user_name)

    }

    interface OnItemClickCallback{
        fun onItemClicked(data: DetailUserParcel)
    }
}