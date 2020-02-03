package com.stackqa.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.google.gson.Gson
import com.stackqa.R
import com.stackqa.management.Utils
import com.stackqa.models.Stack8OverallProducts
import kotlinx.android.synthetic.main.activity_main.*

class StackQAMain : WearableActivity() {

    val TAG: String = "StackQAMain Class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        //validade internal VPN,SSID, Wifi cripto or whathever makes it secure

        //Request to the list os products. If offline, get the last valid json on raw folder
        val products = getListOfProducts()

        //Loading before button appear
        //
        //x button to exit app

        btn_start.setOnClickListener {
            val intent = Intent(this, Products::class.java)
            intent.putExtra("Stack8OverallProducts", products)
            startActivity(intent)

        }

    }

    fun getListOfProducts(): Stack8OverallProducts {

        if (verifyInternetConnection()) {
            //Request list of updated projects and products
        }

        val json = Utils().readJson(baseContext, R.raw.products)
        return Gson().fromJson(json, Stack8OverallProducts::class.java)

    }

    fun verifyInternetConnection(): Boolean {

        val minBandwidthKbps = 320
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val bandWidth: Int = connectivityManager.activeNetwork?.let { activeNetwork ->
            connectivityManager.getNetworkCapabilities(activeNetwork).linkDownstreamBandwidthKbps } ?: -1

        when {
            bandWidth < 0 -> {
                //no active network
                return false
            }
            bandWidth in (0 until minBandwidthKbps) -> {
                //request a high bandwidth network
                return false
            }
            else -> {
                //you already are on a high-bandwidth network, so start your network request
                //Also, update the json on raw folder
                return true
            }
        }
    }

}
