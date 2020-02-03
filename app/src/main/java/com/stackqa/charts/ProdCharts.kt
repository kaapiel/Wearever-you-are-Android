package com.stackqa.charts

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.stackqa.R
import com.stackqa.activities.StackQAMain
import kotlinx.android.synthetic.main.activity_prod_charts.*

class ProdCharts : WearableActivity() {

    val TAG: String = "ProdCharts Class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prod_charts)

        // Enables Always-on
        setAmbientEnabled()

        val breadcrumb = intent.getSerializableExtra("BreadCrumb") as String
        configBreadCrumb(breadcrumb)

        back_button.setOnClickListener {
            val intent = Intent(this, StackQAMain::class.java)
            startActivity(intent)
        }
    }

    private fun configBreadCrumb(breadCrumb: String) {
        txt_breadcrumbs.text = breadCrumb
        txt_breadcrumbs.isSelected = true
    }
}
