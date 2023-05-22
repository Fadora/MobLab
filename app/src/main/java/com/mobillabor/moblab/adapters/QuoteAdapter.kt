package com.mobillabor.moblab.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mobillabor.moblab.R
import com.mobillabor.moblab.model.Quote


class QuoteAdapter(): ListAdapter<Quote, QuoteAdapter.QuoteViewHolder>(QuoteComparator){

    inner class QuoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var quote: Quote? = null;
        private val quoteTextView: TextView = itemView.findViewById(R.id.quote_dialog)


        fun bind(c: Quote){
            quote = c
            quoteTextView.text = quote?.dialog
        }
    }

    //egy listaelem hogy néz ki
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteAdapter.QuoteViewHolder {
        val view :View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.quote_row_item,parent,false)
        return QuoteViewHolder(view)
    }

    //view és data összekötése, melyik poziban melyik elem adatai látszódjanak
    override fun onBindViewHolder(holder: QuoteAdapter.QuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.quote = getItem(position)
    }
}