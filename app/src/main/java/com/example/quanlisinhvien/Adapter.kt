package com.example.quanlisinhvien

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView

class Adapter(private val list : MutableList<studentModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1 ?: LayoutInflater.from(p2?.context).inflate(R.layout.item_layout, p2, false)
        val name = view.findViewById<TextView>(R.id.textView1)
        val mssv = view.findViewById<TextView>(R.id.textView2)
        val imageButton = view.findViewById<ImageButton>(R.id.imageButton)

        name.setText(list[p0].name)
        mssv.setText(list[p0].mssv)

        imageButton.setOnClickListener{
            list.removeAt(p0)
            notifyDataSetChanged()
        }
        return view
    }

}