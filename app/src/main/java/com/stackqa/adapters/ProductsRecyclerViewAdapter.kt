package com.stackqa.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stackqa.R
import com.stackqa.activities.Projects
import com.stackqa.models.Product
import kotlinx.android.synthetic.main.round_button_list_item.view.*

class ProductsRecyclerViewAdapter (
    private val context: Context,
    private val myDataSet: ArrayList<Product>

): RecyclerView.Adapter<ProductsRecyclerViewAdapter.MyViewHolder>()

{
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.round_button_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.item_list_btn_text.text = myDataSet[position].product

        holder.view.item_list_btn_text.setOnClickListener {
            val intent = Intent(context, Projects::class.java)
            val product = myDataSet[position]
            intent.putExtra("BreadCrumb", product.product)
            intent.putExtra("SelectedProduct", product)
            context.startActivity(intent)
        }
    }

    /**
     *
     * Number of Sonar Parameters (Bugs, vulnerabilities, code smells, duplications and coverage)
     *
     * **/
    override fun getItemCount(): Int = myDataSet.size

}