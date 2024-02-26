package com.example.pruebakosmosandroid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakosmosandroid.R
import com.example.pruebakosmosandroid.domain.model.Characters
import com.example.pruebakosmosandroid.ui.interfaces.FragmentListener
import com.squareup.picasso.Picasso
import kotlin.Int

 class ListCharactersAdapter(val listener : FragmentListener) :
    ListAdapter<Characters, ListCharactersAdapter.ViewHolder>(DiffCallback()){

    private class DiffCallback : DiffUtil.ItemCallback<Characters>() {
        override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.adapter_characters, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item,listener)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById(R.id.ivMovie) as ImageView
        private val name = view.findViewById(R.id.tvNameMoview) as TextView
        private val btnVerDetalle = view.findViewById(R.id.btnVerDetalle) as Button

        fun bind(characters: Characters, listener: FragmentListener){
            Picasso.get().load(characters.image).into(image)
            name.text = characters.name
            btnVerDetalle.setOnClickListener {
                listener.setAlertDialog(characters)
            }
        }
    }
}