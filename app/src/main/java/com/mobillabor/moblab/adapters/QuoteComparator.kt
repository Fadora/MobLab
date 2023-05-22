package com.mobillabor.moblab.adapters

import androidx.recyclerview.widget.DiffUtil
import com.mobillabor.moblab.model.Quote


object QuoteComparator : DiffUtil.ItemCallback<Quote>(){
    override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
        return oldItem == newItem
    }
}