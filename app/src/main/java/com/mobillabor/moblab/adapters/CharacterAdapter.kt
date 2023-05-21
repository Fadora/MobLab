package com.mobillabor.moblab.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobillabor.moblab.R
import com.mobillabor.moblab.model.Character


interface OnCharacterClickListener {
    fun onCharacterSelected(h:Character)
}
class CharacterAdapter(): ListAdapter<Character, CharacterAdapter.CharacterViewHolder>(CharacterComparator){
    lateinit var listener: OnCharacterClickListener



    inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var character: Character? = null;
        private val characterTextView: TextView = itemView.findViewById(R.id.character_name)

        init {
            itemView.setOnClickListener {
                character?.let { it ->
                    listener.onCharacterSelected(it)
                }
            }
        }

        fun bind(c: Character){
            character = c
            characterTextView.text = character?.name




        }
    }

    //egy listaelem hogy néz ki
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.CharacterViewHolder {
        val view :View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_row_item,parent,false)
        return CharacterViewHolder(view)
    }

    //view és data összekötése, melyik poziban melyik elem adatai látszódjanak
    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.character = getItem(position)
    }
}