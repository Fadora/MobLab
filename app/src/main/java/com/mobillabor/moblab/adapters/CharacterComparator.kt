package com.mobillabor.moblab.adapters

import androidx.recyclerview.widget.DiffUtil
import com.mobillabor.moblab.model.Character

object CharacterComparator : DiffUtil.ItemCallback<Character>(){
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.charId == newItem.charId
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}