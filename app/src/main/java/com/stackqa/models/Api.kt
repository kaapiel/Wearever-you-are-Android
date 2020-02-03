package com.stackqa.models

import java.io.Serializable

class Api (

    val apiPrefix: String,
    val updateAll: String,
    val getEnvironment: String,
    val getProducts: String

): Serializable
{
    override fun toString(): String {
        return "[Apis: [apiPrefix: ${this.apiPrefix}] " +
                "[updateAll: ${this.apiPrefix+updateAll}] " +
                "[getEnvironment: ${this.apiPrefix+getEnvironment}] " +
                "[getProducts: ${this.apiPrefix+getProducts}]]"
    }
}