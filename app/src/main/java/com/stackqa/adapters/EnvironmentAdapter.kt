package com.stackqa.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.stackqa.R
import com.stackqa.models.Environments

class EnvironmentAdapter(
    context: Context,
    private val dataSource: Environments
) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.round_button_list_item, parent, false)
        val itemListTextValue = rowView.findViewById(R.id.item_list_btn_text) as TextView
        itemListTextValue.text = dataSource.environments[position].environment
        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource.environments[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.environments.size
    }

}