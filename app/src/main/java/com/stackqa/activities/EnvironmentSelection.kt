package com.stackqa.activities

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View
import android.widget.AdapterView
import com.google.gson.Gson
import com.stackqa.R
import com.stackqa.adapters.EnvironmentAdapter
import com.stackqa.charts.DevCharts
import com.stackqa.charts.ProdCharts
import com.stackqa.charts.QACharts
import com.stackqa.management.Utils
import com.stackqa.models.Environment
import com.stackqa.models.Environments
import kotlinx.android.synthetic.main.activity_environment.*
import kotlinx.android.synthetic.main.activity_products.back_button

class EnvironmentSelection : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_environment)

        val project = intent.getSerializableExtra("SelectedProject") as String
        val breadcrumb = intent.getSerializableExtra("BreadCrumb") as String

        configBreadCrumb(breadcrumb)
        configList()

        back_button.setOnClickListener {
            val intent = Intent(this, StackQAMain::class.java)
            startActivity(intent)
        }

        list_environment.setOnItemClickListener { _: AdapterView<*>, _: View, i: Int, _: Long ->
            val env = list_environment.getItemAtPosition(i) as Environment

            val intent: Intent

            intent = when (env.environment) {
                "DEV" -> {
                    Intent(this, DevCharts::class.java)
                }
                "QA" -> {
                    Intent(this, QACharts::class.java)
                }
                else -> {
                    Intent(this, ProdCharts::class.java)
                }
            }

            intent.putExtra("BreadCrumb", breadcrumb.plus(env.environment).plus(" > "))
            intent.putExtra("ProjectSelected", project)
            startActivity(intent)
        }

        // Enables Always-on
        setAmbientEnabled()

    }

    private fun configBreadCrumb(breadCrumb: String) {
        txt_breadcrumbs.text = breadCrumb
    }

    private fun configList() {
        list_environment.adapter = EnvironmentAdapter(this, getListOfEnvironments())
        list_environment.dividerHeight = 0
    }

    private fun getListOfEnvironments(): Environments {
        val json = Utils().readJson(baseContext, R.raw.environment)
        return Gson().fromJson(json, Environments::class.java)
    }

}
