package com.example.characters.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.characters.data.model.Character
import com.example.characters.databinding.ItemCharacterCardBinding
import com.example.characters.presentation.fragment.viewHolder.CharactersViewHolder

class CharactersAdapter() : ListAdapter<Character, CharactersViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Character, newItem: Character) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = ItemCharacterCardBinding.inflate(layoutInflater, parent, false)
        return CharactersViewHolder(view)
    }


    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}