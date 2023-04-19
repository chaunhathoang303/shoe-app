package com.udacity.shoestore

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.udacity.shoestore.models.Shoe

class ShoeItemAdapter(private val context: Activity, private val arrayList: Array<Shoe>) :
    ArrayAdapter<Shoe>(context, R.layout.shoe_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.shoe_item, null)

        val name: TextView = view.findViewById(R.id.shoeName)
        val size: TextView = view.findViewById(R.id.shoeSize)
        val company: TextView = view.findViewById(R.id.shoeCompany)
        val description: TextView = view.findViewById(R.id.shoeDescription)

        name.text = arrayList[position].name
        size.text = arrayList[position].size.toString()
        company.text = arrayList[position].company
        description.text = arrayList[position].description

        return view
    }

}