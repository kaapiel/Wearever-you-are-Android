package com.stackqa.activities

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import com.stackqa.R
import com.stackqa.adapters.ProjectsRecyclerViewAdapter
import com.stackqa.customs.CustomScrollingLayoutCallback
import com.stackqa.models.Product
import kotlinx.android.synthetic.main.activity_projects.*

class Projects : WearableActivity() {

    val TAG: String = "Projects Class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        // Enables Always-on
        setAmbientEnabled()

        val breadCrumb = intent.getStringExtra("BreadCrumb") as String
        configureBreadCrumb(breadCrumb)

        val product = intent.getSerializableExtra("SelectedProduct") as Product
        configProjectList(product, breadCrumb)

        back_button.setOnClickListener {
            val intent = Intent(this, StackQAMain::class.java)
            startActivity(intent)
        }
    }

    private fun configureBreadCrumb(breadCrumb: String) {
        txt_breadcrumbs.text = breadCrumb.plus(" > ")
    }

    private fun configProjectList(product: Product, breadCrumb: String) {

        list_projects.adapter = ProjectsRecyclerViewAdapter(this, product.projects, breadCrumb)
        list_projects.apply {
            isEdgeItemsCenteringEnabled = true
            layoutManager = WearableLinearLayoutManager(context, CustomScrollingLayoutCallback())
            isCircularScrollingGestureEnabled = true
            bezelFraction = 0.5f
            scrollDegreesPerScreen = 90f
        }
    }
}
