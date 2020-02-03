package com.stackqa.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stackqa.R
import com.stackqa.activities.Environments
import kotlinx.android.synthetic.main.round_button_list_item.view.*

class ProjectsRecyclerViewAdapter (
    private val context: Context,
    private val myDataSet: ArrayList<String>,
    private val breadCrumb: String

): RecyclerView.Adapter<ProjectsRecyclerViewAdapter.MyViewHolder>()

{
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.round_button_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.item_list_btn_text.text = myDataSet[position]

        holder.view.item_list_btn_text.setOnClickListener {
            val projectName = myDataSet[position]
            val intent = Intent(context, Environments::class.java)
            intent.putExtra("BreadCrumb", breadCrumb.plus(" > ").plus(projectName).plus(" > "))
            intent.putExtra("SelectedProject", projectName)
            context.startActivity(intent)
        }
    }

    /**
     *
     * Number of Sonar Parameters (Bugs, vulnerabilities, code smells, duplications and coverage)
     *
     * **/
    override fun getItemCount(): Int = myDataSet.size

}