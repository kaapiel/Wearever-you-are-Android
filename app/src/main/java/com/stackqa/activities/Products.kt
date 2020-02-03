package com.stackqa.activities

import android.content.Intent
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import com.stackqa.R
import com.stackqa.adapters.ProductsRecyclerViewAdapter
import com.stackqa.customs.CustomScrollingLayoutCallback
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

        list_products.adapter = ProductsRecyclerViewAdapter(this, stack8OverallProducts.products as ArrayList<Product>)
        list_products.apply {
            isEdgeItemsCenteringEnabled = true
            layoutManager = WearableLinearLayoutManager(context, CustomScrollingLayoutCallback())
            isCircularScrollingGestureEnabled = true
            bezelFraction = 0.5f
            scrollDegreesPerScreen = 90f
        }
    }
}
