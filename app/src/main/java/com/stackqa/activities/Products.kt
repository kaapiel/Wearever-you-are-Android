package com.stackqa.activities

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.view.View
import android.widget.AdapterView
import com.stackqa.R
import com.stackqa.adapters.ProductsAdapter
import com.stackqa.models.Product
import com.stackqa.models.Stack8OverallProducts
import kotlinx.android.synthetic.main.activity_products.*

class Products : WearableActivity() {

    val TAG: String = "Systems Class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val stack8OverallProducts = intent.getSerializableExtra("Stack8OverallProducts") as Stack8OverallProducts

        configList(stack8OverallProducts)

        back_button.setOnClickListener {
            val intent = Intent(this, StackQAMain::class.java)
            startActivity(intent)
        }

        // Enables Always-on
        setAmbientEnabled()

    }

    private fun configList(stack8OverallProducts: Stack8OverallProducts) {

        list_products.adapter = ProductsAdapter(this, stack8OverallProducts.products as ArrayList<Product>)
        list_products.dividerHeight = 0

        list_products.setOnItemClickListener { _: AdapterView<*>, _: View, i: Int, _: Long ->

            val intent = Intent(this, Projects::class.java)
            val product = list_products.getItemAtPosition(i) as Product
            intent.putExtra("BreadCrumb", product.product)
            intent.putExtra("SelectedProduct", product)
            startActivity(intent)
        }
    }


}
