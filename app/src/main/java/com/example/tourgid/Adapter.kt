package com.example.tourgid

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(private val context: Activity, private val arraylist: ArrayList<Place>): ArrayAdapter<Place>(context, R.layout.list_item, arraylist)
{
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view:View = inflater.inflate(R.layout.list_item, null)

        val imageView: ImageView = view.findViewById(R.id.place_pic)
        val placename: TextView = view.findViewById(R.id.place_title)
        val placedesc: TextView = view.findViewById(R.id.place_desc)


        imageView.setImageResource(arraylist[position].imageid)
        placename.text = arraylist[position].title
        placedesc.text = arraylist[position].description

        return view
    }
}