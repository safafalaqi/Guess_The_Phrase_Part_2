package com.example.guessthephrasepart2

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(private val text: ArrayList<String>): RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val text=text[position]
        holder.itemView.apply{
            tvText.text = text
            if(text.startsWith("You" )||text.startsWith("Found")){
                tvText.setTextColor(Color.GREEN)
            }else if(text.startsWith("Wrong")){
                tvText.setTextColor(Color.RED)
            }else{
                tvText.setTextColor(Color.BLACK)
            }
        }
    }

    override fun getItemCount()= text.size
}