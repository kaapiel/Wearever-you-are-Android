package com.stackqa.charts

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.stackqa.R
import com.stackqa.activities.StackQAMain
import com.stackqa.adapters.SonarRecyclerViewAdapter
import com.stackqa.customs.PagerIndicatorDecoration
import com.stackqa.management.Utils
import kotlinx.android.synthetic.main.activity_dev_charts.*

class DevCharts : WearableActivity() {

    val TAG: String = "DevCharts Class"
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev_charts)

        // Enables Always-on
        setAmbientEnabled()

        val breadcrumb = intent.getSerializableExtra("BreadCrumb") as String
        configBreadCrumb(breadcrumb)

        back_button.setOnClickListener {
            val intent = Intent(this, StackQAMain::class.java)
            startActivity(intent)
        }

        val stubTools = Utils().generateStubTools()

        viewManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewAdapter = SonarRecyclerViewAdapter(stubTools.sonar)

        list_charts.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            PagerSnapHelper().attachToRecyclerView(list_charts)
            list_charts.addItemDecoration(PagerIndicatorDecoration())
        }
    }

    private fun configBreadCrumb(breadCrumb: String) {
        txt_breadcrumbs.text = breadCrumb
    }
}
