package com.stackqa.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stackqa.R
import com.stackqa.charts.DevCharts
import com.stackqa.charts.ProdCharts
import com.stackqa.charts.QACharts
import com.stackqa.models.Environments
import kotlinx.android.synthetic.main.round_button_list_item.view.*

class EnvironmentRecyclerViewAdapter (
    private val context: Context,
    private val myDataSet: Environments,
    private val breadCrumb: String,
    private val project: String

): RecyclerView.Adapter<EnvironmentRecyclerViewAdapter.MyViewHolder>()

{
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.round_button_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.item_list_btn_text.text = myDataSet.environments[position].environment

        holder.view.item_list_btn_text.setOnClickListener {
            val env = myDataSet.environments[position]

            val intent: Intent

            intent = when (env.environment) {
                "DEV" -> {
                    Intent(context, DevCharts::class.java)
                }
                "QA" -> {
                    Intent(context, QACharts::class.java)
                }
                else -> {
                    Intent(context, ProdCharts::class.java)
                }
            }

            intent.putExtra("BreadCrumb", breadCrumb.plus(env.environment).plus(" > "))
            intent.putExtra("ProjectSelected", project)
            context.startActivity(intent)
        }
    }

    /**
     *
     * Number of Sonar Parameters (Bugs, vulnerabilities, code smells, duplications and coverage)
     *
     * **/
    override fun getItemCount(): Int = myDataSet.environments.size

}