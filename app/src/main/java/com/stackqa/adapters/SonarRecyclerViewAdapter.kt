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
import com.stackqa.models.tools.Sonar
import kotlinx.android.synthetic.main.pie_chart.view.*
import kotlin.math.roundToInt

class SonarRecyclerViewAdapter (private val myDataSet: Sonar

): RecyclerView.Adapter<SonarRecyclerViewAdapter.MyViewHolder>()

{
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pie_chart, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val chart = holder.view.pie_chart

        chart.legend.isEnabled = false
        chart.description.isEnabled = false

        chart.setUsePercentValues(true)
        chart.setExtraOffsets(0f, 0f, 0f, 0f)

        chart.dragDecelerationFrictionCoef = 0.95f

        chart.isDrawHoleEnabled = true
        chart.setHoleColor(Color.BLACK)
        chart.setTransparentCircleColor(Color.WHITE)
        chart.setTransparentCircleAlpha(110)
        chart.holeRadius = 70f
        chart.transparentCircleRadius = 61f
        chart.setDrawCenterText(false)
        chart.rotationAngle = 0f

        // enable rotation of the chart by touch
        chart.isRotationEnabled = true
        chart.isHighlightPerTapEnabled = true

        // add a selection listener
        // chart.setUnit(" €");
        // chart.setDrawUnitsInChart(true);
        // add a selection listener
        //chart.setOnChartValueSelectedListener()

        chart.animateY(1400, Easing.EaseInOutQuad)
        // chart.spin(2000, 0, 360);

        // entry label styling
        chart.setEntryLabelColor(Color.WHITE)
        //chart.setEntryLabelTypeface(tfRegular)
        chart.setEntryLabelTextSize(8f)

        val entries: ArrayList<PieEntry> = ArrayList()

        // add a lot of colors
        val colors: ArrayList<Int> = ArrayList()

        when (position) {
            0 -> {
                if (myDataSet.bugs != 0) { entries.add(PieEntry(myDataSet.bugs.toFloat(), "")) } else entries.add(PieEntry(1f, ""))
                when (myDataSet.bugsRating) {
                    1 -> {
                        colors.add(Utils().sonarRatingColors[0])
                        holder.view.dev_label_rating.text = "A"
                    }
                    2 -> {
                        colors.add(Utils().sonarRatingColors[1])
                        holder.view.dev_label_rating.text = "B"
                    }
                    3 -> {
                        colors.add(Utils().sonarRatingColors[2])
                        holder.view.dev_label_rating.text = "C"
                    }
                    4 -> {
                        colors.add(Utils().sonarRatingColors[3])
                        holder.view.dev_label_rating.text = "D"
                    }
                    5 -> {
                        colors.add(Utils().sonarRatingColors[4])
                        holder.view.dev_label_rating.text = "E"
                    }
                }
                holder.view.dev_label_description.text = "Bugs"
                chart.isDrawHoleEnabled = false
                holder.view.image_issue.setImageResource(R.mipmap.sonar_bug)
                holder.view.number_issue.text = "${myDataSet.bugs}"
            }
            1 -> {
                if (myDataSet.vulnerabilities != 0) { entries.add(PieEntry(myDataSet.vulnerabilities.toFloat(), "")) } else entries.add(PieEntry(1f, ""))
                when (myDataSet.vulnerabilitiesRating) {
                    1 -> {
                        colors.add(Utils().sonarRatingColors[0])
                        holder.view.dev_label_rating.text = "A"
                    }
                    2 -> {
                        colors.add(Utils().sonarRatingColors[1])
                        holder.view.dev_label_rating.text = "B"
                    }
                    3 -> {
                        colors.add(Utils().sonarRatingColors[2])
                        holder.view.dev_label_rating.text = "C"
                    }
                    4 -> {
                        colors.add(Utils().sonarRatingColors[3])
                        holder.view.dev_label_rating.text = "D"
                    }
                    5 -> {
                        colors.add(Utils().sonarRatingColors[4])
                        holder.view.dev_label_rating.text = "E"
                    }
                }
                holder.view.dev_label_description.text = "Vulnerabilities"
                chart.isDrawHoleEnabled = false
                holder.view.image_issue.setImageResource(R.mipmap.sonar_vulnerability)
                holder.view.number_issue.text = "${myDataSet.vulnerabilities}"
            }
            2 -> {
                if (myDataSet.codeSmells != 0) { entries.add(PieEntry(myDataSet.codeSmells.toFloat(), "")) } else entries.add(PieEntry(1f, ""))
                when (myDataSet.codeSmellRating) {
                    1 -> {
                        colors.add(Utils().sonarRatingColors[0])
                        holder.view.dev_label_rating.text = "A"
                    }
                    2 -> {
                        colors.add(Utils().sonarRatingColors[1])
                        holder.view.dev_label_rating.text = "B"
                    }
                    3 -> {
                        colors.add(Utils().sonarRatingColors[2])
                        holder.view.dev_label_rating.text = "C"
                    }
                    4 -> {
                        colors.add(Utils().sonarRatingColors[3])
                        holder.view.dev_label_rating.text = "D"
                    }
                    5 -> {
                        colors.add(Utils().sonarRatingColors[4])
                        holder.view.dev_label_rating.text = "E"
                    }
                }
                holder.view.dev_label_description.text = "Code Smells"
                chart.isDrawHoleEnabled = false
                holder.view.image_issue.setImageResource(R.mipmap.sonar_code_smell)
                holder.view.number_issue.text = "${myDataSet.codeSmells}"

            }
            3 -> {
                entries.add(PieEntry(myDataSet.coverage.toFloat(), ""))
                entries.add(PieEntry(100-myDataSet.coverage.toFloat(), ""))
                for (c in Utils().okNokColors) colors.add(c)
                holder.view.dev_label_description.text = "Coverage"
                holder.view.dev_label_rating.text = "${myDataSet.coverage.roundToInt()}%"
            }
            4 -> {
                entries.add(PieEntry(myDataSet.duplications.toFloat(), ""))
                entries.add(PieEntry(100-myDataSet.duplications.toFloat(), ""))
                for (c in Utils().nokOkColors) colors.add(c)
                holder.view.dev_label_description.text = "Duplications"
                holder.view.dev_label_rating.text = "${myDataSet.duplications.roundToInt()}%"
            }

            //dataSet.setSelectionShift(0f);
        }

        val dataSet = PieDataSet(entries, "Election Results")

        dataSet.colors = colors
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0f, 0f)
        dataSet.selectionShift = 5f
        dataSet.setDrawValues(false)

        //dataSet.setSelectionShift(0f);

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
     * Number of Sonar Parameters (Bugs, vulnerabilities, code smells, duplications and coverage)
     *
     * **/
    override fun getItemCount(): Int = 5

}