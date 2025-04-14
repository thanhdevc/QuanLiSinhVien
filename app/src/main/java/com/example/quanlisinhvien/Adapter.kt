package com.example.quanlisinhvien

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val list : MutableList<studentModel>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.textView1)
        val mssv = itemView.findViewById<TextView>(R.id.textView2)
        val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student = list[position]
        holder.name.text = student.name
        holder.mssv.text = student.mssv

        holder.imageButton.setOnClickListener{
            list.removeAt(position)
            holder.name.text = ""
            holder.mssv.text = ""
            notifyDataSetChanged()
        }

    }


}