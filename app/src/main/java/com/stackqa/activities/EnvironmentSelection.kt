package com.stackqa.activities

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import com.google.gson.Gson
import com.stackqa.R
import com.stackqa.adapters.EnvironmentRecyclerViewAdapter
import com.stackqa.customs.CustomScrollingLayoutCallback
import com.stackqa.management.Utils
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
        configList(breadcrumb, project)

        back_button.setOnClickListener {
            val intent = Intent(this, StackQAMain::class.java)
            startActivity(intent)
        }

        // Enables Always-on
        setAmbientEnabled()

    }

    private fun configBreadCrumb(breadCrumb: String) {
        txt_breadcrumbs.text = breadCrumb
    }

    private fun configList(breadCrumb: String, project: String) {

        list_environment.adapter = EnvironmentRecyclerViewAdapter(this, getListOfEnvironments(), breadCrumb, project)
        list_environment.apply {
            isEdgeItemsCenteringEnabled = true
            layoutManager = WearableLinearLayoutManager(context, CustomScrollingLayoutCallback())
            isCircularScrollingGestureEnabled = true
            bezelFraction = 0.5f
            scrollDegreesPerScreen = 90f
        }

    }

    private fun getListOfEnvironments(): Environments {
        val json = Utils().readJson(baseContext, R.raw.environment)
        return Gson().fromJson(json, Environments::class.java)
    }

}
