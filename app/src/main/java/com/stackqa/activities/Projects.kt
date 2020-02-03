package com.stackqa.activities

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View
import android.widget.AdapterView
import com.stackqa.R
import com.stackqa.adapters.ProjectsAdapter
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
        configProjectList(product)

        back_button.setOnClickListener {
            val intent = Intent(this, StackQAMain::class.java)
            startActivity(intent)
        }

        list_projects.setOnItemClickListener { _: AdapterView<*>, _: View, i: Int, _: Long ->

            val projectName = list_projects.getItemAtPosition(i) as String
            val intent = Intent(this, EnvironmentSelection::class.java)

            intent.putExtra("BreadCrumb", breadCrumb.plus(" > ").plus(projectName).plus(" > "))
            intent.putExtra("SelectedProject", projectName)
            startActivity(intent)


        }
    }

    private fun configureBreadCrumb(breadCrumb: String) {
        txt_breadcrumbs.text = breadCrumb.plus(" > ")
    }

    private fun configProjectList(product: Product) {
        list_projects.adapter = ProjectsAdapter(this, product.projects)
        list_projects.dividerHeight = 0
    }
}
