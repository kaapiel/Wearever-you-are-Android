package com.stackqa.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF
import com.stackqa.R
import com.stackqa.management.Utils
import com.stackqa.models.tools.Jira
import kotlinx.android.synthetic.main.jira_options.view.*

class JiraRecyclerViewAdapter (private val myDataSet: Jira

): RecyclerView.Adapter<JiraRecyclerViewAdapter.MyViewHolder>()

{
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jira_options, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val chart = holder.view.pie_chart
        val entries: ArrayList<PieEntry> = ArrayList()
        val colors: ArrayList<Int> = ArrayList()
        chart.isDrawHoleEnabled = false
        chart.legend.isEnabled = false

        chart.animateY(1400, Easing.EaseInOutQuad)

        chart.holeRadius = 70f
        chart.isDrawHoleEnabled = true
        chart.setHoleColor(Color.BLACK)
        chart.setTransparentCircleColor(Color.WHITE)
        chart.setTransparentCircleAlpha(110)

        chart.isRotationEnabled = true
        chart.isHighlightPerTapEnabled = true

        when (position) {
            0 -> {
                entries.add(PieEntry(0f))
                holder.view.image_issue.setImageResource(R.mipmap.sonar_bug)
                holder.view.number_issue.text = myDataSet.bugs.toString()
                holder.view.qa_label_description.text = "Bugs"
            }
            1 -> {
                entries.add(PieEntry(0f))
                holder.view.image_issue.setImageResource(R.mipmap.trending)
                holder.view.number_issue.text = myDataSet.improvements.toString()
                holder.view.qa_label_description.text = "Improvements"
            }
            2 -> {
                entries.add(PieEntry(myDataSet.execution.passed.toFloat(), ""))
                entries.add(PieEntry(myDataSet.execution.failed.toFloat(), ""))
                for (c in Utils().okNokColors) colors.add(c)
                holder.view.qa_label_description.text = "Execution"
                chart.description.text = ""
                chart.centerText = "${myDataSet.execution.passed.toInt()}%"
                chart.setCenterTextSize(25f)
                chart.setCenterTextColor(Color.WHITE)
            }
        }

        val dataSet = PieDataSet(entries, "Election Results")

        dataSet.colors = colors
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 0f)
        dataSet.selectionShift = 5f
        dataSet.setDrawValues(false)

        val data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter(chart))
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        chart.data = data

        chart.highlightValues(null)
        chart.invalidate()
    }

    /**
     *
     * Number of Jira Parameters (Bugs, improvements and execution)
     *
     * **/
    override fun getItemCount(): Int = 3

}